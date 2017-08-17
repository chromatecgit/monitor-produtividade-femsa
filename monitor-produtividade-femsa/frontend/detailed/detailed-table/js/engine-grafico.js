function createLojasDiasChart(ctx, xLabelParam, chartData, max) {
	var dataMined = mineObjects(chartData, 'qntdLojasVisitadas');
	var arrayMax = createMaxLine(max, dataMined.length);
	var myChart = new Chart(ctx, {
		type: 'line',
		data: {
			labels: xLabelParam,
			datasets: [{
				label: 'Progresso',
				data: dataMined,
				options: {
					tooltips: {
						mode: 'point'
					}
				},
				backgroundColor: [
					'rgba(255, 99, 132, 1)',
				],
				borderColor: [
					'rgba(255, 99, 132, 1)',
				],
				borderWidth: 1
			},{
				label: 'Meta',
				data: arrayMax,
				options: {
					tooltips: {
						mode: 'point'
					}
				},
				borderColor: [
					'rgba(0, 0, 0, 0.3)',
				],
				backgroundColor: [
					'rgba(0, 0, 0, 0.3)',
				],
				borderWidth: 1,
			}]
		},
		options: {
			legend: {
				position: 'top',
			},
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero:true,
						stacked:true
					},
					type:'linear',
					scaleLabel: {
						display: true,
						labelString: 'Lojas',
						fontColor: '#222',
						fontSize: 11
					}
				}],
				xAxes: [{
					ticks: {
						stacked:true
					},
					scaleLabel: {
						display: true,
						labelString: 'Dias',
						fontColor: '#222',
						fontSize: 11
					}
				}]
			},
			layout: {
				padding: {
					left: 50,
					right: 0,
					top: 0,
					bottom: 0
				}
			}
		}
	});
}


function createFinalizadasOcorrenciasChart(ctx, xLabelParam, chartData1) {
	var dataMined1 = mineObjects(chartData1, 'qntdLojasVisitadas');
	var dataMined2 = mineObjects(chartData1, 'qntdOcorrencias');
	var myChart = new Chart(ctx, {
		type: 'bar',
		data: {
			labels: xLabelParam,
			datasets: [{
				label: 'Dias',
				data: dataMined1,
				options: {
					tooltips: {
						mode: 'point'
					}
				},
				backgroundColor: [
					'rgba(255, 99, 132, 1)',
				],
				borderColor: [
					'rgba(255, 99, 132, 1)',
				],
				borderWidth: 1
			},{
				label: 'Visitas',
				data: dataMined2,
				options: {
					tooltips: {
						mode: 'point'
					}
				},
				borderColor: [
					'rgba(0, 0, 0, 0.3)',
				],
				backgroundColor: [
					'rgba(0, 0, 0, 0.3)',
				],
				borderWidth: 1,
			}]
		},
		options: {
			legend: {
				position: 'top',
			},
			scales: {
				yAxes: [{
					ticks: {
						beginAtZero:true,
						stacked:true
					},
					type:'linear',
					scaleLabel: {
						display: true,
						labelString: 'Dias',
						fontColor: '#222',
						fontSize: 11
					}
				}],
				xAxes: [{
					ticks: {
						stacked:true
					},
					scaleLabel: {
						display: true,
						labelString: 'Ocorrencias',
						fontColor: '#222',
						fontSize: 11
					}
				}]
			},
			layout: {
				padding: {
					left: 50,
					right: 0,
					top: 0,
					bottom: 0
				}
			}
		}
	});
}

function mineObjects(data, property) {
	var mined = new Array();
	for (var obj of data) {
		mined.push(obj[property]);
	}
	return mined;
}

function createMaxLine(max, reps) {
	var maxLineArray = new Array();
	for (var i = 0; i < reps; i++) {
		maxLineArray.push(max);
	}
	return maxLineArray;
}