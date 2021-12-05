const express = require('express');
const bodyParser = require('body-parser');
const app = express();
// parse application/x-www-form-urlencoded
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false })) 

const laboRoutes = require('./routes/labos');
const RegionRoutes = require('./routes/region');
const AdminRoutes = require('./routes/admin');
const RsltRoutes = require('./routes/Resultats');
const PatientRoutes = require('./routes/route');
const ResltRoutes = require('./routes/rslt');
const LogRoutes = require('./routes/Login');

//pour accepter le requet des route distinct 
app.use((req, res, next) => {
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content, Accept, Content-Type, Authorization');
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, PATCH, OPTIONS');
    next();
  });
app.use('/api/labo',laboRoutes);
app.use('/api/region',RegionRoutes);
app.use('/api/admin',AdminRoutes);
app.use('/api/Resultat',RsltRoutes);
app.use('/api/resultat',ResltRoutes);
app.use('/listpatient',PatientRoutes);
app.use('/api/Login',LogRoutes)
//connection.end();
module.exports = app;