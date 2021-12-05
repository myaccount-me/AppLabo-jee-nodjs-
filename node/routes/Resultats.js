const express = require('express');
const router = express.Router();
const Resultat = require('../controller/ResultatController');

//get all
router.get('/',Resultat.GetallLabos);
router.post('/',Resultat.CreateLabo);
router.delete('/:id',Resultat.DeletedResultat)
router.put('/:id',Resultat.update)
module.exports = router;