const secret = require('../Secret/secret');
const express = require('express');
const userModel = require('../models/userModel');
const cookieParser = require('cookie-parser');
const userRouter = express.Router();
const protectRoute = require('./protectRoute');
userRouter
.route('/')
.get(getUser)
.delete(deleteUser)
.patch(updateUser)

// let login = true;
async function getUser(req,res){
try{
    //  if(login){
     let data = await userModel.find();
     res.status(200).send(data);
     console.log(data);
    }
  catch(err){
    console.log("error",err);
  }
}
async function deleteUser(req,res){
   try{
   await userModel.deleteOne(req.body);
   res.status(200).send("sucess");
   }catch(err){
    console.log("error",err);
   }
}
async function updateUser(req,res){
  try{
    await userModel.updateOne(req.body);
    res.status(200).send("update Successfully");
  }catch(err){
    console.log("error",err);
  }
}

module.exports = userRouter;