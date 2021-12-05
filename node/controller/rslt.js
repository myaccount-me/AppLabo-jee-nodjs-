const connection = require('./connexionBD');
var dateFormat = require("dateformat");


exports.GetallRslt= (request , res) => {
    const req = request.query;
    let query = "select * from resultat where id_patient = ?";
    const params=[req.id_patient];
   // let id_patient = req.params.id_patient;
    connection.query(query,params,  (err, rows ) => {
        if (!err){
        res.send(rows);
        console.log(rows)
       // console.log(req.body.nom)
        }
        else
        console.log(err);
            });
}
exports.CreateRslt=(req, res, next) => {
    let query = "INSERT INTO resultat (id_labo,id_patient,date,etat) VALUES (?, ?, ?, ?);"
    // Value to be inserted
    console.log(req.body)
    console.log(req.body.nom)
    // let id_rslt = req.body.id_rslt;
     let id_labo = req.body.idLabo;
     let id_patient = req.body.idPatient;
     console.log("id pat:",id_patient)
    //let aujourdhui = new Date();
   let date1 = new Date(req.body.date) ;
  let date = dateFormat(date1 , "yyyy-mm-dd");
    let etat = req.body.etat;
    // Creating queries
    connection.query(query, [id_labo,id_patient,date,etat], (err, rows) => {
        if (err) throw err;
        console.log("Row inserted with id = "+ rows.insertId);
        res.send(rows);
    });
    }

exports.DeletedResultat= (req, res, next) => {
 connection.query("DELETE FROM resultat where id_rslt = ?", req.params.id , function (err, result){
        if (!err)
       { res.send('delteted seccessfully');
        console.log("deleted:",req.params.id)}
        else
        console.log(err);
            });
        }