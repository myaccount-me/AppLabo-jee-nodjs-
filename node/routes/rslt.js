const express = require('express');
const router = express.Router();
const RsltController = require('../controller/rslt');
router.get('/',RsltController.GetallRslt)
router.post('/',RsltController.CreateRslt)
router.delete('/:id',RsltController.DeletedResultat)
module.exports = router;