const connection = require('./connexionBD');
exports.GetallLabos= (req, res, next) => {
connection.query("select * from labo", function (err, result) {
if (!err){
res.send(result);
}
else
console.log(err);
    });
}
exports.CreateLabo=(req, res, next) => {
let query = `INSERT INTO labo (nom,login,mdp,email,id_region) VALUES (?, ?, ?, ?, ?);`;
// Value to be inserted
let userName = req.body.nom;
let userAddress = req.body.email;
let login = req.body.login;
let mdp = req.body.mdp;
let id_reg = req.body.id_region;
// Creating queries
connection.query(query, [userName,login,mdp,userAddress,id_reg], (err, rows) => {
    if (err) throw err;
    console.log("Row inserted with id = "+ rows.insertId);
    res.status(200).json({ message: 'Objet ajouté !'})
})      
}
exports.UpdateLabo=(req, res, next) => {
    // update statment 
let sql = `UPDATE labo SET  nom = ?, login = ?,mdp = ?, email = ?, id_region = ? WHERE labo.id_labo = ?`;
let userName = req.body.nom;
let userAddress = req.body.email;
let login = req.body.login;
let mdp = req.body.mdp;
let id_reg = req.body.id_region;
let id = req.params.id
// execute the UPDATE statement
connection.query(sql, [userName,login,mdp,userAddress,id_reg,id], (error, results, fields) => {
    if (error){
      return console.error(error.message);
    }
    console.log('Rows affected:', results.affectedRows);
    res.status(200).json({ message: 'Objet modifié!'})
  });
}
exports.DeleteLabo= (req, res, next) => {
    let id = req.params.id
    connection.query("DELETE FROM labo WHERE id_labo = ?", [id],(err, results, fields) => {
        if(err) {
            console.log("error: ", err);
        }
        else{
        console.log("Row deleted with success ");
        res.status(200).json({ message: 'Objet supprimé !'})

        }
        });
}