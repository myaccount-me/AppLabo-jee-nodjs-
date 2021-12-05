const connection = require('./connexionBD');

exports.GetallPatients= (req , res) => {
    connection.query("select * from patient", function (err, result) {
        if (!err)
        res.send(result);
        else
        console.log(err);
            });
}

    // exports.Createpat=(req, res, next) => {
    //     let query = "INSERT INTO patient (id_pat,cin,nom,prenom,dnaiss,telephone,email,sexe,id_region) VALUES (?, ?, ?, ?, ?,?,?,?,?);"
    //     // Value to be inserted
    //     console.log(req.body)
    //     console.log(req.body.nom)
    //     let id_pat = req.body.id_pat;
    //     let cin = req.body.cin;
    //     let nom = req.body.nom;
    //     let prenom = req.body.prenom;
    //     let dnaiss = req.body.dnaiss;
    //     let telephone = req.body.telephone;
    //     let email = req.body.email;
    //     let sexe = req.body.sexe;
    //     let id_region = req.body.id_region ;
    //     // Creating queries
    //     connection.query(query, [id_pat,cin,nom,prenom,dnaiss,telephone,email,sexe,id_region], (err, rows) => {
    //         if (err) throw err;
    //         console.log("Row inserted with id = "+ rows.insertId);
    //     });
    //     }
