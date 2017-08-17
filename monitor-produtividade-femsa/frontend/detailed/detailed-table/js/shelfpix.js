$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "http://ec2-54-191-107-92.us-west-2.compute.amazonaws.com:8085/monitor",
        context: document.body,
        dataType: "json"
    }).done(function(jsonSupervisor) {
       buildDashboard(jsonSupervisor);
    });

    function buildDashboard(supervisor) {
        console.log(supervisor);
        /* ========================================================== * 
        * ===================== SUPERVISOR ========================= *
        * ========================================================== */
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
        }
        // 1. PASSO - Contruir as tags fundamentais das tabelas
        setUpTablesFrames($('#supervisor-data'), supervisorPanelsBasicStruct);
        // 2. PASSO - Montar as tabelas e anexa-las no lugar correto
        // SUPERVISOR - META
        var configTableMeta = {
            'target' : $('#' + divSupervisorMetaMainGroupID),
            'id' : supervisorTableMetaID,
            'class' : [supervisorTableClasses, supervisorMainGroupClasses],
            'orderLike' : 'meta',
            'etc' : null,
            'header' : {
                'html' : 'Meta',
                'colspan' : '2',
                'class' : tableHeadersClasses['meta']
            },
            'data' : supervisor.meta,
            'showDescription' : true
        };
        
        createTable(configTableMeta);

        // SUPERVISOR - PROJECAO
        var configTableProjecao = {
            'target' :$('#' + divSupervisorMetaMainGroupID),
            'id' : supervisorTableProjecaoID,
            'class' : [supervisorTableClasses],
            'orderLike' : 'projecao',
            'etc' : null,
            'header' : {
                'html' : 'Projecao',
                'colspan' : '2',
                'class' : []
            },
            'data' : supervisor.meta.projecao,
            'showDescription' : true
        };
        
        createTable(configTableProjecao);

        // SUPERVISOR - PERFORMANCE
        var configTablePerformance = {
            'target' : $('#' + divSupervisorMetaSubGroupID),
            'id' : supervisorTablePerformanceID,
            'class' : [supervisorTableClasses],
            'orderLike' : 'performance',
            'etc' : null,
            'header' : {
                'html' : 'Performance /Dia Meta',
                'colspan' : '2',
                'class' : tableHeadersClasses['performance']
            },
            'data' : supervisor.meta.performance,
            'showDescription' : true
        };
        
        createTable(configTablePerformance);

        // SUPERVISOR - ACUMULADO
        var configTableAcumulado = {
            'target' : $('#' + divSupervisorMetaSubGroupID),
            'id' : supervisorTableAcumuladoID,
            'class' : [supervisorTableClasses],
            'orderLike' : 'acumulado',
            'etc' : null,
            'header' : {
                'html' : 'Acumulado',
                'colspan' : '1',
                'class' : tableHeadersClasses['acumulado']
            },
            'data' : supervisor.meta.acumulado,
            'showDescription' : false
        };
        
        createTable(configTableAcumulado);

        // SUPERVISOR - PROGRESSO DIARIO META
        var configTableProgressoDiario = {
            'target' : $('#' + divSupervisorMetaSubGroupID),
            'id' : supervisorTableProgDiarID,
            'class' : [supervisorTableClasses],
            'orderLike' : 'progresso',
            'etc' : null,
            'header' : {
                'html' : '',
                'colspan' : '',
                'class' : tableHeadersClasses['progdiar']
            },
            'data' : supervisor.meta.listaProgressoMeta,
            'showDescription' : false
        };
        createProgressoDiarioTable(configTableProgressoDiario);

        // SUPERVISOR - PERFORMANCE FOTO
        var configTablePerformanceFoto = {
            'target' : $('#' + divSupervisorDetailFotoID),
            'id' : supervisorTablePerformanceFotoID,
            'class' : [supervisorTableClasses],
            'orderLike' : 'foto',
            'etc' : null,
            'header' : {
                'html' : 'Performance / Dia Foto',
                'colspan' : '2',
                'class' : tableHeadersClasses['performance']
            },
            'data' : supervisor.detalhe.performanceFoto,
            'showDescription' : true
        };
        createTable(configTablePerformanceFoto);

        // SUPERVISOR - ACUMULADO FOTO
        var configTableAcumuladoFoto = {
            'target' : $('#' + divSupervisorDetailFotoID),
            'id' : supervisorTableAcumuladoFotoID,
            'class' : [supervisorTableClasses],
            'orderLike' : 'foto',
            'etc' : null,
            'header' : {
                'html' : 'Acumulado',
                'colspan' : '2',
                'class' : tableHeadersClasses['acumulado']
            },
            'data' : supervisor.detalhe.acumuladoFoto,
            'showDescription' : false
        };
        createTable(configTableAcumuladoFoto);

        // SUPERVISOR - PROGRESSO DIARIO FOTO
        var configTableProgDiarFoto = {
            'target' : $('#' + divSupervisorDetailFotoID),
            'id' : supervisorTableProgDiarFotoID,
            'class' : [supervisorTableClasses],
            'orderLike' : 'progresso',
            'etc' : null,
            'header' : {
                'html' : '',
                'colspan' : '',
                'class' : tableHeadersClasses['progdiar']
            },
            'data' : supervisor.detalhe.listaProgressoFoto,
            'showDescription' : false
        };   
        createProgressoDiarioTable(configTableProgDiarFoto);

        // SUPERVISOR - PERFORMANCE PRECO
        var configTablePerformancePreco = {
            'target' : $('#' + divSupervisorDetailPrecoID),
            'id' : supervisorTablePerformancePrecoID,
            'class' : [supervisorTableClasses],
            'orderLike' : 'preco',
            'etc' : null,
            'header' : {
                'html' : 'Performance / Dia Preco',
                'colspan' : '2',
                'class' : tableHeadersClasses['performance']
            },
            'data' : supervisor.detalhe.performancePreco,
            'showDescription' : true
        };
        createTable(configTablePerformancePreco);

        // SUPERVISOR - ACUMULADO PRECO
        var configTableAcumuladoPreco = {
            'target' : $('#' + divSupervisorDetailPrecoID),
            'id' : supervisorTableAcumuladoPrecoID,
            'class' : [supervisorTableClasses],
            'orderLike' : 'preco',
            'etc' : null,
            'header' : {
                'html' : 'Acumulado',
                'colspan' : '2',
                'class' : tableHeadersClasses['acumulado']
            },
            'data' : supervisor.detalhe.acumuladoPreco,
            'showDescription' : false
        };
        createTable(configTableAcumuladoPreco);

        // SUPERVISOR - PROGRESSO DIARIO PRECO
        var configTableProgDiarPreco = {
            'target' : $('#' + divSupervisorDetailPrecoID),
            'id' : supervisorTableProgDiarPrecoID,
            'class' : [supervisorTableClasses],
            'orderLike' : 'progresso',
            'etc' : null,
            'header' : {
                'html' : '',
                'colspan' : '',
                'class' : tableHeadersClasses['progdiar']
            },
            'data' : supervisor.detalhe.listaProgressoPreco,
            'showDescription' : false
        };   
        createProgressoDiarioTable(configTableProgDiarPreco);

        /* ========================================================== * 
        * ===================== PESQUISADORES ========================= *
        * ========================================================== */

        for (var pesquisador of supervisor.pesquisadores) {
            var pesquisadorNewDivIDs = {};
            var pesquisadorNewDivMetaIDs = {};
            var pesquisadorNewDivDetailIDs = {};
            var pesquisadorNewTableIDs = {};
            var pesquisadorNewTableDetailsIDS = {};

            for (var id in pesquisadorRawDivMetaIDs) {
                pesquisadorNewDivMetaIDs[id] = formatPesquisadorID(pesquisadorRawDivMetaIDs[id], pesquisador['id']);
            }

            for (var id in pesquisadorRawDivDetailIDs) {
                pesquisadorNewDivDetailIDs[id] = formatPesquisadorID(pesquisadorRawDivDetailIDs[id], pesquisador['id']);
            }

            for (var id in pesquisadorRawTableIDs) {
                pesquisadorNewTableIDs[id] = formatPesquisadorID(pesquisadorRawTableIDs[id], pesquisador['id']);
            }

            for (var id in pesquisadorRawTableDetailsIDS) {
                pesquisadorNewTableDetailsIDS[id] = formatPesquisadorID(pesquisadorRawTableDetailsIDS[id], pesquisador['id']);
            }

            for (var id in pesquisadorRawDivIDs) {
                pesquisadorNewDivIDs[id] = formatPesquisadorID(pesquisadorRawDivIDs[id], pesquisador['id']);
            }

            var pesquisadorPanelsBasicStruct = {
                'pesquisador' : {
                    'meta' : {
                        'id' : pesquisadorNewDivMetaIDs['metaPanelID'],
                        'children' : {
                            1 : pesquisadorNewDivMetaIDs['metaMainGroupID'],
                            2 : pesquisadorNewDivMetaIDs['metaSubGroupID']
                        }
                    },
                    'detail' : {
                        'id' : pesquisadorNewDivDetailIDs['detailPanelID'],
                        'children' : {
                            1 : pesquisadorNewDivDetailIDs['detailFotoID'],
                            2 : pesquisadorNewDivDetailIDs['detailPrecoID'],
                            3 : pesquisadorNewDivDetailIDs['detailQuestID']
                        }
                    }
                },
                'id' : pesquisadorNewDivIDs['id']
            }
            // 1. PASSO - Contruir as tags fundamentais das tabelas
            setUpTablesFrames($('#pesquisadores-data'), pesquisadorPanelsBasicStruct);
            $('#pesquisadores-data').find('#' + pesquisadorNewDivIDs['id']).prepend('<h3>' + pesquisador['nome'] + ' ' + pesquisador['sobrenome'] + '</h3>');
            // 2. PASSO - Montar as tabelas e anexa-las no lugar correto
            // PESQUISADOR - META
            var configTableMeta = {
                'target' : $('#' + pesquisadorNewDivMetaIDs['metaMainGroupID']),
                'id' : pesquisadorNewTableIDs['tableMetaID'],
                'class' : [supervisorTableClasses],
                'orderLike' : 'meta',
                'etc' : null,
                'header' : {
                    'html' : 'Meta',
                    'colspan' : '2',
                    'class' : tableHeadersClasses['performance']
                },
                'data' : pesquisador.meta,
                'showDescription' : true
            };
            createTable(configTableMeta);

            // PESQUISADOR - PROJECAO
            var configTableProjecao = {
                'target' : $('#' + pesquisadorNewDivMetaIDs['metaMainGroupID']),
                'id' : pesquisadorNewTableIDs['tableProjecaoID'],
                'class' : [supervisorTableClasses],
                'orderLike' : 'projecao',
                'etc' : null,
                'header' : {
                    'html' : 'Projecao',
                    'colspan' : '2',
                    'class' : []
                },
                'data' : pesquisador.meta.projecao,
                'showDescription' : true
            };
            createTable(configTableProjecao);

            // PESQUISADOR - PERFORMANCE
            var configTablePerformance = {
                'target' : $('#' + pesquisadorNewDivMetaIDs['metaSubGroupID']),
                'id' : pesquisadorNewTableIDs['tablePerformanceID'],
                'class' : [supervisorTableClasses],
                'orderLike' : 'performance',
                'etc' : null,
                'header' : {
                    'html' : 'Performance / Dia Meta', 
                    'colspan' : '2',
                    'class' : tableHeadersClasses['performance']
                },
                'data' : pesquisador.meta.performance,
                'showDescription' : true
            };
            createTable(configTablePerformance);

            // PESQUISADOR - ACUMULADO
            var configTableAcumulado = {
                'target' : $('#' + pesquisadorNewDivMetaIDs['metaSubGroupID']),
                'id' : pesquisadorNewTableIDs['tableAcumuladoID'],
                'class' : [supervisorTableClasses],
                'orderLike' : 'acumulado',
                'etc' : null,
                'header' : {
                    'html' : 'Acumulado',
                    'colspan' : '1',
                    'class' : tableHeadersClasses['acumulado']
                },
                'data' : pesquisador.meta.acumulado,
                'showDescription' : false
            };
            createTable(configTableAcumulado);

            // PESQUISADOR - PROGRESSO DIARIO META
            var configTableProgressoDiario = {
                'target' : $('#' + pesquisadorNewDivMetaIDs['metaSubGroupID']),
                'id' : pesquisadorNewTableIDs['tableProgDiarID'],
                'class' : [supervisorTableClasses],
                'orderLike' : 'progresso',
                'etc' : null,
                'header' : {
                    'html' : '',
                    'colspan' : '',
                    'class' : tableHeadersClasses['progdiar']
                },
                'data' : pesquisador.meta.listaProgressoMeta
            };
            createProgressoDiarioTable(configTableProgressoDiario);

            // PESQUISADOR - PERFORMANCE FOTO
            var configTablePerformanceFoto = {
                'target' : $('#' + pesquisadorNewDivDetailIDs['detailFotoID']),
                'id' : pesquisadorNewTableDetailsIDS['tablePerformanceFotoID'],
                'class' : [supervisorTableClasses ],
                'orderLike' : 'foto',
                'etc' : null,
                'header' : {
                    'html' : 'Performance / Dia Foto',
                    'colspan' : '2',
                    'class' : tableHeadersClasses['performance']
                },
                'data' : pesquisador.detalhe.performanceFoto,
                'showDescription' : true
            };
            createTable(configTablePerformanceFoto);

            // PESQUISADOR - ACUMULADO FOTO
            var configTableAcumuladoFoto = {
                'target' : $('#' + pesquisadorNewDivDetailIDs['detailFotoID']),
                'id' : pesquisadorNewTableDetailsIDS['tableAcumuladoFotoID'],
                'class' : [supervisorTableClasses ],
                'orderLike' : 'foto',
                'etc' : null,
                'header' : {
                    'html' : 'Acumulado',
                    'colspan' : '2',
                    'class' : tableHeadersClasses['acumulado']
                },
                'data' : pesquisador.detalhe.acumuladoFoto,
                'showDescription' : false
            };
            createTable(configTableAcumuladoFoto);

            // PESQUISADOR - PROGRESSO DIARIO FOTO
            var configTableProgDiarFoto = {
                'target' : $('#' + pesquisadorNewDivDetailIDs['detailFotoID']),
                'id' : pesquisadorNewTableDetailsIDS['tableProgDiarFotoID'],
                'class' : [supervisorTableClasses ],
                'orderLike' : 'progresso',
                'etc' : null,
                'header' : {
                    'html' : '',
                    'colspan' : '',
                    'class' : tableHeadersClasses['progdiar']
                },
                'data' : pesquisador.detalhe.listaProgressoFoto,
                'showDescription' : false
            };   
            createProgressoDiarioTable(configTableProgDiarFoto);

            // PESQUISADOR - PERFORMANCE PRECO
            var configTablePerformancePreco = {
                'target' : $('#' + pesquisadorNewDivDetailIDs['detailPrecoID']),
                'id' : pesquisadorNewTableDetailsIDS['tablePerformancePrecoID'],
                'class' : [supervisorTableClasses ],
                'orderLike' : 'preco',
                'etc' : null,
                'header' : {
                    'html' : 'Performance / Dia Preco',
                    'colspan' : '2',
                    'class' : tableHeadersClasses['performance']
                },
                'data' : pesquisador.detalhe.performancePreco,
                'showDescription' : true
            };
            createTable(configTablePerformancePreco);

            // PESQUISADOR - ACUMULADO PRECO
            var configTableAcumuladoPreco = {
                'target' : $('#' + pesquisadorNewDivDetailIDs['detailPrecoID']),
                'id' : pesquisadorNewTableDetailsIDS['tableAcumuladoPrecoID'],
                'class' : [supervisorTableClasses ],
                'orderLike' : 'preco',
                'etc' : null,
                'header' : {
                    'html' : 'Acumulado',
                    'colspan' : '2',
                    'class' : tableHeadersClasses['acumulado']
                },
                'data' : pesquisador.detalhe.acumuladoPreco,
                'showDescription' : false
            };
            createTable(configTableAcumuladoPreco);

            // PESQUISADOR - PROGRESSO DIARIO PRECO
            var configTableProgDiarPreco = {
                'target' : $('#' + pesquisadorNewDivDetailIDs['detailPrecoID']),
                'id' : pesquisadorNewTableDetailsIDS['tableProgDiarPrecoID'],
                'class' : [supervisorTableClasses ],
                'orderLike' : 'progresso',
                'etc' : null,
                'header' : {
                    'html' : '',
                    'colspan' : '',
                    'class' : tableHeadersClasses['progdiar']
                },
                'data' : pesquisador.detalhe.listaProgressoPreco,
                'showDescription' : false
            };   
            createProgressoDiarioTable(configTableProgDiarPreco);
        }
    }

    function setUpTablesFrames($parent, basicStructure) {
        var $supervisorMetaPanel;
        if (basicStructure['pesquisador']) {
            $parent.append($('<div>', {'id' : basicStructure['id']}));
            for (var structureType in basicStructure['pesquisador']) {
                $supervisorMetaPanel = $('<div>', {'id' : basicStructure['pesquisador'][structureType]['id']});
                var childrenObj = basicStructure['pesquisador'][structureType]['children'];
                for (var child in childrenObj) {
                    $supervisorMetaPanel.append($('<div>', {'id' : childrenObj[child]}));
                }
                $parent.find('#' + basicStructure['id']).append($supervisorMetaPanel);
            }
        } else {
            for (var structureType in basicStructure) {
                $supervisorMetaPanel = $('<div>', {'id' : basicStructure[structureType]['id']});
                var childrenObj = basicStructure[structureType]['children'];
                for (var child in childrenObj) {
                    $supervisorMetaPanel.append($('<div>', {'id' : childrenObj[child]}));
                }
                $parent.append($supervisorMetaPanel);
            }
        }
    }

    function formatPesquisadorID(rawID, pesquisadorID) {
        return rawID.replace(/\*/g, pesquisadorID);
    }
});

