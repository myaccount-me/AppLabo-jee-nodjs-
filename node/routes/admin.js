const express = require('express');
const router = express.Router();
const AdminController = require('../controller/admin');
//get all
router.get('/',AdminController.LogAdmin);
module.exports = router;