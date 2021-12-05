const express = require('express');
const router = express.Router();
const RegionController = require('../controller/region');
//get all
router.get('/',RegionController.GetallRegion);
module.exports = router;