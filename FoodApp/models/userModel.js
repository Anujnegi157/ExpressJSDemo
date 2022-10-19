const mongoose  = require("mongoose");
const email  = require("email-validator");
const secret = require('../Secret/secret');
mongoose.connect(secret.DB_LINK,{
  // userNewUrlParser : true,
  // userCreateIndex : true, 
  // userUnifiedTopology : true,

   
}).then(function(db){
  // console.log(db);
  console.log("db");
}).catch(function(err){
  console.log("error",err);
})

const userSchema = new mongoose.Schema({
  name : {
    type : String ,
    require : true,
    unique : true,
    
  },
  email : {
    type : String,
    require : true ,
    unique : true,
    validate : function(){
      return email.validate(this.email);
    }
  },
  password : {
    type : String ,
    require : true ,
    
  },
  confirmPassword : {
    type : String,
    require : true ,
    validate : function(){
      return this.password == this.confirmPassword;
    }
  },
  token : {
    type : Number
  }
})
userSchema.pre("save",function(){
  this.confirmPassword=undefined;
})
userSchema.methods.resetHandler = function(password,confirmPassword){
  this.password = password;
  this.confirmPassword=confirmPassword;
  this.token = undefined;
} 
const userModel = mongoose.model("userModel",userSchema);
module.exports = userModel;
// (async function createUser(){
// let userObj = {
//  name : "Anuj",
//  email : "Anujnegi157@gmail.com",
//  password : "qwerty",
//  confirmPassword : "qwerty"
  

// }
// let user = await userModel.create(userObj);
// console.log(user);
// })();

