const express = require('express');
const router = express.Router();
const laboController = require('../controller/labo');
//get all
router.get('/',laboController.GetallLabos);
//les requete post
router.post('/', laboController.CreateLabo);
//modification 
router.put('/:id',laboController.UpdateLabo);
//suppression 
router.delete('/:id',laboController.DeleteLabo);
module.exports = router;