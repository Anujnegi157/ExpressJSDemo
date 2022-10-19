const secret = require('../Secret/secret');
const express = require('express');
const userModel = require('../models/userModel');
const cookieParser = require('cookie-parser');
const jwt = require('jsonwebtoken');
const sendMail = require('../ExternalApi/smsapi');

// console.log(secret.JWT_KEY);


const authRouter = express.Router();

authRouter
 .post("/signup",check,signupUser)
 .post("/login",loginUser)
 .post("/forgetpassword",forgetpassword)
 .post("/resetpassword",resetpassword)
 .get("/signout",signout);


 function signout(req,res){
  
  //  let userCookies = req.cookies;
   if(req.cookies.jwtToken){
    res.clearCookie("jwtToken");
    
    res.status(200).send({
      msg : "done "
    })
    res.end();
   }

 }
 function check(req,res,next){
   let obj = req.body;
    let length = Object.keys(obj).length;
    if(length==0){
      res.status(400).send({
        msg : "can't create user when obj is empty please fill the details"
      })
    }
    next();
 }
 async function  signupUser(req,res){
  try{
    let obj = req.body;
    let user = await userModel.create(obj);
    res.status(200).send(user);
  }catch(err){
    console.log("error",err);
  }
}



async function loginUser(req,res){
  try{
    let userobj = await userModel.findOne({email : req.body.email});
   if(req.body.email){
       
        //  console.log(userobj.email);
        //  console.log(userobj.password == req.body.password);
        //  console.log(userobj.password);
        // //  console.log( req.body.password);
         if(userobj.password == req.body.password){
          let payload = userobj["_id"];
          // let payload = "A";
          // console.log(payload);
          let token = jwt.sign({payload}, secret.JWT_KEY);
          res.cookie("jwtToken",token,{httpOnly : true});
          console.log("create succesfuuly");
          return res.status(200).send({
            msg : "login Succesfully",
            username : userobj.name,
          })
         }else{
          res.status(404).send({
            msg : "something went wrong email or password"
          })
         }
   }else{
     res.status(404).send({
      msg : "email or password is wrong"
     })
   }
}catch(err){
  console.log("error",err);
}
}

function generateOTP(limit) {
  
  let digits = '0123456789';
  let OTP = '';
  for (let i = 0; i < limit; i++ ) {
      OTP += digits[Math.floor(Math.random() * 10)];
  }
  return OTP;
}

async function resetpassword(req,res){
   let userDetails = req.body;
   if(userDetails.token){

    let user = await userModel.findOne({token : userDetails.token});
    console.log("working");
     user.resetHandler(userDetails.password,userDetails.confirmPassword);
     await user.save();
     res.status(200).json({
      msg : "password changed"
     })
   }else{
     res.status(404).send({
      msg : " please provide us token"
     })
   }
}
async function forgetpassword(req,res){
  
   let user =  await userModel.findOne({ email : req.body.email});
   try{
    if(user){
       let tokenNo = generateOTP(4);
       console.log(tokenNo);
       await userModel.updateOne({email: req.body.email},{token:tokenNo});
       sendMail(req.body.email,tokenNo);
       res.status(200).json({
        msg  : "your token is " + tokenNo
       })

    }else{
     res.send(404).json({
       msg : "No email account from this account"
     })
    }
   }catch(err){
     console.log("error",err);
   }
  
}
module.exports =  authRouter;