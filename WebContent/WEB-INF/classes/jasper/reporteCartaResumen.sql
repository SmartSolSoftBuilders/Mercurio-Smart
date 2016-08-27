SELECT
	cer.numCertificado,
       	slc.apPaternoSolicitante, slc.apMaternoSolicitante, slc.nombre1Solicitante,
        slc.nombre2Solicitante, slc.fechaNacimientoSolicitante,
	pol.numPoliza, pol.numConsignatario, pol.sumaAseguradaIndividual,
	paq.nombrePaquete,
        	tar.importeTarifa, tar.importePrimaInd,
	pol.sumaBAF sumaAseguradaBAFPoliza,
          baf.sumaAseguradaBAF bafOriginal,
	pol.sumaGastosFunerarios,pol.sumaSEVI,
        pla.cvePlaza, pla.domicilioPlaza, pla.lada, pla.telefono, pla.horarioAtencion,
        agt.cveAgente, agt.cveSupervisor, agt.cveGerente,ret.cveDescuento
FROM
	CertificadoIndividual cer join
  PolizaIndividual pol on
  cer.folioSolicitud = pol.folioSolicitud and cer.formatoSolicitud = pol.formatoSolicitud
  join Solicitud sol on
  sol.folioSolicitud=pol.folioSolicitud and sol.formatoSolicitud = pol.formatoSolicitud
  join Solicitante slc on
  slc.RFCsolicitante=sol.RFCsolicitante left outer join
	PaqueteVidaDxN paq on
  paq.idPaqueteVidaDxN=pol.tipoSeguro left outer join
  TarifaAportMensual tar on
  tar.cveTarifa=sol.cveTarifa join
  Plaza pla on
  pla.idPlaza=cer.idPlaza join
  Agente agt on
  agt.cveAgente=sol.cveAgente join
  Empresa epr on
  epr.cveEmpresa = sol.cveEmpresa join
	GrupoAsegurado gpo on
  gpo.cveGrupoAsegurado = epr.cveGrupoAsegurado left outer join
  Retenedor ret on
  ret.cveRetenedor=gpo.cveRetenedor left outer join
  BAF baf on
  baf.idPaqueteVidaDxN = paq.idPaqueteVidaDxN
  AND baf.importePrimaBAF = tar.cveTarifa
WHERE cer.numCertificado=$P{numCertificadoParam}
AND pol.numPoliza=$P{numPolizaParam}