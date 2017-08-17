var basicTableInnerStructure = '<thead></thead><tfoot></tfoot><tbody></tbody>';

function createTable(config) {
    var $table = createElement(1, new ElementModel('table', config['id'], formatClass(config['class']), config['etc']));
    $table.append(basicTableInnerStructure);

    var $thead = $('<th>', buildTableDescriptions(dictionary, config['header']));
    $table.find('thead').append($thead);

    var $tableTBody = $table.find('tbody');

    organizeAndCreateTable(config['data'], dictionary, $tableTBody, config['showDescription'], config['orderLike']);
 
    $(config['target']).append($table);
}

function organizeAndCreateTable(obj, dictionary, $targetElement, showDescription, type) {
    var properties = Object.keys(obj);
    if (properties.indexOf('dataDeRegistro') > -1) {
        properties.splice(properties.indexOf('dataDeRegistro'), 1);
    }
    var $rows = createEmptyRows(properties.length, $targetElement);
    for (var property of properties) {
        if (obj.hasOwnProperty(property)) {
            var $row;
            switch (type) {
                case 'performance':
                    $row = (PerformanceHierarchyList[property] - 1) !== -1 ? $rows.eq(PerformanceHierarchyList[property] - 1) : null;
                    addContentToTableBody(obj, property, $row, showDescription, type);
                    break;
                case 'projecao' :
                    $row = (ProjecaoHierarchyList[property] - 1) !== -1 ? $rows.eq(ProjecaoHierarchyList[property] - 1) : null;
                    addContentToTableBody(obj, property, $row, showDescription, type);
                    break;
                case 'meta' :
                    $row = (MetaHierarchyList[property] - 1) !== -1 ? $rows.eq(MetaHierarchyList[property] - 1) : null;
                    addContentToTableBody(obj, property, $row, showDescription, type);
                    break;
                case 'foto':
                    $row = (FotoHierarchyList[property] - 1) !== -1 ? $rows.eq(FotoHierarchyList[property] - 1) : null;
                    addContentToTableBody(obj, property, $row, showDescription, type);
                    break;
                case 'preco':
                    $row = (PrecoHierarchyList[property] - 1) !== -1 ? $rows.eq(PrecoHierarchyList[property] - 1) : null;
                    addContentToTableBody(obj, property, $row, showDescription, type);
                    break;
                default:
                    $row = (PerformanceHierarchyList[property] - 1) !== -1 ? $rows.eq(PerformanceHierarchyList[property] - 1) : null;
                    addContentToTableBody(obj, property, $row, showDescription, type);
                    break;
            }
        }       
    }
}

function createProgressoDiarioTable(config) {
    var $table = createElement(1, new ElementModel('table', config['id'], formatClass(config['class']), config['etc']));
    $table.append(basicTableInnerStructure);
    var $tableTHead = $table.find('thead');
    var $tableTBody = $table.find('tbody');
    if (config['data']) {
        var properties = filterUnwantedProperties(Object.keys(config['data'][0]))
        createEmptyRows(properties.length, $tableTBody);
    
        for (var day of config['data']) {
            config['header']['html'] = day['dia'];
            $tableTHead.append($('<th>', config['header']));
            var keys = properties;
            $.each($tableTBody.find('tr'), function(index, row) {
                $(row).append('<td>' + checkType(config['type'], day[keys[index]], keys[index]) +'</td>');
            });
        }

        $(config['target']).append($table);
    }
}

function createEmptyRows(numberOfRows, $targetElement) {
    while (numberOfRows != 0) {
        $targetElement.append('<tr></tr>');
        numberOfRows--;
    }
    return $('tr', $targetElement);
}

function addContentToTableBody(obj, property, $row, showDescription, type) {
    if ($row) {
        if (showDescription) {
            $row.append(
                '<td> '+ buildTableDescriptions(dictionary, property) +'</td>');
        }
        $row.append('<td>' + checkType(type, obj[property], property) + '</td>');
    }
}

function isHiddenProperty(property) {
    for (var hidden of hiddenProperties) {
        if (property === hidden)
        return true;
    }
    return false;
}

function filterUnwantedProperties(properties) {
    for (var unwantedProperty of unwantedProperties) {
        for (var property of properties) {
            if (property === unwantedProperty) {
                properties.splice(properties.indexOf(unwantedProperty), 1);
            }
        }
    }
    return properties;
}

function formatClass(classes) {
    var classValue = '';
    for (var c of classes) {
        classValue = classValue.concat(c + " ");
    }
    return classValue;
}