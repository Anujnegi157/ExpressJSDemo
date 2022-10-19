const jwt = require('jsonwebtoken');
const { JWT_KEY } = require('../Secret/secret');
function protectRoute(req,res,next){
  //  console.log(req.cookies);
   if(req.cookies.jwtToken){
       try{
         let decode = jwt.verify(req.cookies.jwtToken,JWT_KEY);
         if(decode){
            next();
         }
       }catch(err){
        console.log("error",err);
       }
      //  next();
   }else{
    res.status(404).send({
      msg : "please ReLogin succesfull"
    })
   }
   
}

module.exports=protectRoute;