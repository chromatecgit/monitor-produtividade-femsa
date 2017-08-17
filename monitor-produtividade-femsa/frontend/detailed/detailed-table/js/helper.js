var PerformanceHierarchyList = {
    'qntdLojasVisitadas'  : 1,
    'qntdOcorrencias'  : 2,
    'qntdDiasUteis'  : 3,
    'qntdHorasTrabalho'  : 4,
    'velocidadeMedia'  : 5,
    'mediaLojasDia' : 6
}

var ProjecaoHierarchyList = {
    'metaAjustada'  : 3,
    'projecaoOcorrencias'  : 4,
    'amostraProvavel' : 5,
    'ajusteHorasTrabalhadasDia' : 2,
    'qntdAdicionalLojas' : 1 
}

var MetaHierarchyList = {
    'qntdPesquisadores' :1,
    'totalLojasVisitar' : 2,
	'totalDiasUteis' : 3,
	'horasTrabalhadasDia' : 4,
	'totalHorasTrabalho' : 5,
	'mediaLojasDia': 6,
	'velocidadeMediaVisitas' : 7,
	'listaProgressoMeta': 0,
	'performance': 0,
	'acumulado': 0,
	'projecao': 0
}

var FotoHierarchyList = {
    'tiradas' : 1,
    'recebidas' : 2,
    'evidencia' : 3,
    'ocorrencia' : 4,
    'processaveis' : 5,
    'automatico' : 6,
    'manual' : 7,
    'descarte' : 8,
    'publicadas' : 9 
}

var PrecoHierarchyList = {
    'capturados' : 1,
    'publicados' : 2,
}

var QuestionarioHierarchyList = {
    'preenchidos' : 1,
    'publicados' : 2,
}

// CONSTRUCTOR
function ElementModel(htmlElement, htmlId , htmlClass, etc) {
        this.htmlElement = htmlElement;
        this.htmlId = htmlId;
        this.htmlClass = htmlClass;
        //can be a json
        this.etc = etc;
}

var dictionary = {
    'Uteis' : 'Úteis',
    'Media' : 'Média',
    'Qntd' : 'Qntd.',
    'Projecao' : 'Projeção',
    'Provavel' : 'Provável',
    'Evidencia' : 'Evidência',
    'Ocorrencia' : 'Ocorrência',
    'Processaveis' : 'Processáveis',
    'Automatico' : 'Automático',
    'Ocorrencias' : 'Ocorrências',
    'Preco' : 'Preço'
};

var hiddenProperties = [
    'performance', 
    'acumulado', 
    'listaProgressoMeta', 
    'projecao',
    'dataRegistro'];

function createElement(quantity, elementModel) {
    if (elementModel) {
        //simple creation
        if (!elementModel.etc) {
            for (var i = 0; i < quantity; i++) {
                var $element = $('<'+ elementModel.htmlElement +'>', 
                {'id' : elementModel.htmlId, 'class' : elementModel.htmlClass});
                return $element;
            }
        //complex creation
        } else {
            var propertiesJSON = {};
            var $element;
            propertiesJSON['id'] = elementModel.htmlId;
            propertiesJSON['class'] = elementModel.htmlClass;
            for (var property in elementModel.etc) {
                if (elementModel.etc.hasOwnProperty(property)) {
                    propertiesJSON[property] = elementModel.etc[property];
                }
            }
            for (var i = 0; i < quantity; i++) {
                $element = $('<'+ elementModel.htmlElement +'>', propertiesJSON);
                
            }
            return $element;
        }
    }

}

function buildTableDescriptions(dictionary, title) {
    var newTitle = [];
    if (typeof(title) !== 'object') {
        // Deixa as iniciais maiusculas - Codigo por palavras
        title = title.charAt(0).toUpperCase() + title.substring(1);
        newTitle = useDictionary(
            findWord(title, new Array()), dictionary);
        var text = newTitle.join();
        return text.replace(/,/g, '');
    } else {
        var html = title['html'];
        html = html.charAt(0).toUpperCase() + html.substring(1);
        newTitle = useDictionary(
            findWord(html, new Array()), dictionary);
        var text = newTitle.join();
        text = text.replace(/,/g, '');
        title['html'] = text;
        return title;
    }
}

function useDictionary(title, dictionary) {
    var transformedTitle = [];
    for (var word of title) {
        if (dictionary.hasOwnProperty(word)) {
            transformedTitle.push(dictionary[word]);
        } else {
            transformedTitle.push(word);
        }
    }
    return transformedTitle;
}

function findWord(title, words) {
    var words = words;
    if (title) {
        for (var i = 1; i <= title.length; i++) {
            if (title.charAt(i) === title.charAt(i).toUpperCase()) {
                var word = title.substring(i, 0);
                var remainingTitle = title.replace(word, '');
                words.push(word);
                words.push(' ');
                return findWord(remainingTitle, words);
            }
        }
    }
    return words;
}

function checkType(origin, value, property) {
    if (value != null && value.hasOwnProperty('seconds')) {
        return formatTime(value);
    } else if (!isNaN(value)) {
        return parseData(origin, value, property)
    }
    return value;
}

function formatTime(value) {
    var time;
    if (value.seconds != 0) {
        var seconds = value.seconds;
        var h = Math.floor(seconds / 3600);
        var m = Math.floor(seconds % 3600 / 60);
        var s = Math.floor(seconds % 3600 % 60);
        if (h < 10) {
            h = '0'+ h;
        }

        if (m < 10) {
            m = '0' + m;
        }
        time = h + ':' + m;
        return time;
    } else {
        return '00:00';
    }
}

function parseData(origin, value, property) {
    if (isInPerformancePercentageList(property) && origin === 'performance') {
        if (!isNaN(value)) {
            value = Math.floor(value * 100);
            value = value + '%';
            return value;
        }
    } else if (isInDoubleList(property)) {
        value = value.toFixed(2);
        return value;
    }
    return value;
}

function isInDoubleList(property) {
    var list = ['metaAjustada', 
                'amostraProvavel', 
                'ajusteHorasTrabalhadasDia', 
                'velocidadeMedia', 
                'velocidadeMediaVisitas', 
                'mediaLojasDia', 
                'projecaoOcorrencias',
                'evidencia',
                'ocorrencia',
                'qntdAdicionalLojas'];
    for (var item of list) {
        if (property === item) {
            return true;
        }
    }
    return false; 
}

function isInPerformancePercentageList(property) {
    var list = ['qntdLojasVisitadas', 'qntdOcorrencias', 'qntdHorasTrabalho', 'mediaLojasDia', 'velocidadeMedia'];
    for (var item of list) {
        if (property === item) {
            return true;
        }
    }
    return false;
}

function getAllDatesUntilToday() {
    var currentDate = new Date();
    var day = currentDate.getDate();
    var arrayDates = [];
    for (var i = 1; i <= day; i++) {
        var dateString = formatDate(i, currentDate.getMonth());
        arrayDates.push(dateString);
    }
    return arrayDates;
}

function formatDate(day) {
    var dateString = '';
    if (day < 10) {
        dateString = dateString.concat('0' + day);
    } else {
        dateString = dateString.concat(day);
    }

    return dateString;
}