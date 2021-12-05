const express = require('express');
const { route } = require('../app');
const router = express.Router();
const patController = require('../controller/controlleur');
//get all patient
router.get('/',patController.GetallPatients);
//add result
//router.post('/' , patController.Createpat)
module.exports = router;