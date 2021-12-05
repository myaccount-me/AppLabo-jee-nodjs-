const express = require('express');
const router = express.Router();
const log = require('../controller/LoginController');
//router.get('/admin', log.LogAdmin);
router.get('/labo', log.LogLabo);
module.exports = router;