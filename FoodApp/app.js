const express = require('express');

const app = express();
app.use(express.json());
app.use(express.static('public'));

const authRouter = express.Router();


let db = [];
app.use('/api/auth',authRouter);

function signupUser(req,res){
    // console.log("line no 14",req.body);
    let  db1 = req.body;
    console.log(req.body);
    db.push(db1);
    res.send(req.body);
}
function loginUser(req,res){
  
}
authRouter
 .post("/signup",signupUser)
 .post("/login",loginUser)




 
app.get('/',(req,res)=>{
  res.send("Hello  from Backend");
})
app.listen(5000,function(){
  console.log("Server Started");
})
