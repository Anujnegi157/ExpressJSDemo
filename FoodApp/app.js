const express = require('express');
const cookieParser = require('cookie-parser');
const authRouter = require('./route/auth');
const userModel = require("./models/userModel");
const userRouter = require('./route/user')

const app = express();
app.use(cookieParser());
app.use(express.json());
app.use(express.static('public'));


app.use('/api/auth',authRouter);
app.use('/api/user',userRouter);
app.listen(5000,function(){
  console.log("Server Started");
})



