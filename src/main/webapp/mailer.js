/*
var nodemailer = require("nodemailer");
var exports = module.exports();
var smtpTransport = nodemailer.createTransport("SMTP",{
    service: "Gmail",  // sets automatically host, port and connection security settings
    auth: {
        user: "c13438208@mydit.ie",
        pass: "willow2013"
    }
});

var mailOptions = {
    from: "c13438208@mydit.ie", // sender address.  Must be the same as authenticated user if using Gmail.
    to: "c13438208@mydit.ie", // receiver
    subject: "Emailing with nodemailer", // subject
    text: "Email Example with nodemailer"
};

exports.smtpTransport.sendMail(mailOptions, function(error, response){
    if(error){
        console.log(error);
    }else{
        console.log("Message sent: " + response.message);
    }

    smtpTransport.close(); // shut down the connection pool, no more messages.  Comment this line out to continue sending emails.
});
*/
