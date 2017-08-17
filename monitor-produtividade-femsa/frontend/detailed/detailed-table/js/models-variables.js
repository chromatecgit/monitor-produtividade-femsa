/*********************************************** 
                    SUPERVISOR
************************************************/

//IDs de Supervisor do Painel de Metas 
var divSupervisorMetaPanelID = 'supervisor-meta-panel';
var divSupervisorMetaMainGroupID = 'supervisor-meta-maingroup';
var divSupervisorMetaSubGroupID = 'supervisor-meta-subgroup';
/* IDs de Supervisor do Painel de Detalhes */
var divSupervisorDetailPanelID = 'supervisor-detail-panel';
var divSupervisorDetailFotoID = 'supervisor-detail-foto';
var divSupervisorDetailPrecoID = 'supervisor-detail-preco';
var divSupervisorDetailQuestID = 'supervisor-detail-quest';
/* IDs de Supervisor das Tabelas Main */
var supervisorTableMetaID = 'supervisor-table-meta';
var supervisorTableProjecaoID = 'supervisor-table-projecao';
var supervisorTablePerformanceID = 'supervisor-table-performance';
var supervisorTableAcumuladoID = 'supervisor-table-acumulado';
var supervisorTableProgDiarID = 'supervisor-table-progdiar';
var supervisorMetaGraficoID = 'supervisor-meta-grafico';
/* IDs de Supervisor das Tabelas Detail */
var supervisorTablePerformanceFotoID = 'supervisor-table-performance-foto';
var supervisorTableAcumuladoFotoID = 'supervisor-table-performance-foto';
var supervisorTableProgDiarFotoID = 'supervisor-table-performance-foto';
var supervisorTablePerformancePrecoID = 'supervisor-table-performance-preco';
var supervisorTableAcumuladoPrecoID = 'supervisor-table-performance-preco';
var supervisorTableProgDiarPrecoID = 'supervisor-table-performance-preco';
/* Classes das tabelas de Supervisor */
var supervisorTableClasses = 'table-striped';
var supervisorMainGroupClasses = 'bold-content';

var supervisorPanelsBasicStruct = {
    'meta' : {
        'id' : divSupervisorMetaPanelID,
        'children' : {
            1 : divSupervisorMetaMainGroupID,
            2 : divSupervisorMetaSubGroupID
        }
    },
    'detail' : {
        'id' : divSupervisorDetailPanelID,
        'children' : { 
            1 : divSupervisorDetailFotoID,
            2 : divSupervisorDetailPrecoID,
            3 : divSupervisorDetailQuestID
        }
    }
};

/*********************************************** 
                    PESQUISADOR
************************************************/
/* IDs de Pesquisador do Painel de Metas */
var pesquisadorRawDivIDs = {
    'id' : 'pesquisador-*'
};
var pesquisadorRawDivMetaIDs = {
    'metaPanelID':'pesquisador-*-meta-panel',
    'metaMainGroupID' : 'pesquisador-*-meta-maingroup',
    'metaSubGroupID' : 'pesquisador-*-meta-subgroup'
};
/* IDs de Pesquisador do Painel de Detalhes */
var pesquisadorRawDivDetailIDs = {
    'detailPanelID' : 'pesquisador-*-detail-panel',
    'detailFotoID' : 'pesquisador-*-detail-foto',
    'detailPrecoID' : 'pesquisador-*-detail-preco',
    'detailQuestID' : 'pesquisador-*-detail-quest'
};
/* IDs de Pesquisador das Tabelas Main */
var pesquisadorRawTableIDs = {
	'tableMetaID' : 'pesquisador-*-table-meta',
	'tableProjecaoID' : 'pesquisador-*-table-projecao',
	'tablePerformanceID': 'pesquisador-*-table-performance',
	'tableAcumuladoID' : 'pesquisador-*-table-acumulado',
	'tableProgDiarID' : 'pesquisador-*-table-progdiar',
	'metaGraficoID' : 'pesquisador-*-meta-grafico'
};
/* IDs de Pesquisador das Tabelas Detail */
var pesquisadorRawTableDetailsIDS = {
    'tablePerformanceFotoID' : 'pesquisador-*-table-performance-foto',
    'tableAcumuladoFotoID' : 'pesquisador-*-table-performance-foto',
    'tableProgDiarFotoID' : 'pesquisador-*-table-performance-foto',
    'tablePerformancePrecoID' : 'pesquisador-*-table-performance-preco',
    'tableAcumuladoPrecoID' : 'pesquisador-*-table-performance-preco',
    'tableProgDiarPrecoID' : 'pesquisador-*-table-performance-preco'
};

var tableHeadersClasses = {
    'meta' : 'th-meta',
    'performance' : 'th-performance',
    'acumulado' : 'th-acumulado',
    'progdiar' : 'th-progdiar'
};

var unwantedProperties = ['dia', 'dataDeRegistro'];