// Выводить сообщения об ошибках
window.onerror = function(msg, url, linenumber) {
    alert('Error message: '+msg+'\nURL: '+url+'\nLine Number: '+linenumber);
    return true;
}
let plot = document.getElementById("plot")
let ctx = plot.getContext("2d");
const width = plot.clientWidth
const height = plot.clientHeight
const radius = width * 2 / 5

function realToDrawnX(xToConvert, r) {
    return (xToConvert - width / 2) / width * (5 / 2) * r
}

function realToDrawnY(yToConvert, r) {
    return (yToConvert - height / 2) / height * (-5 / 2) * r
}

function drawnToRealX(xToConvert, r) {
    return 2 * width * xToConvert / 5 / r  + width / 2
}

function drawnToRealY(yToConvert, r) {
    return -2 * height * yToConvert / 5 / r + height / 2
}

function dot(x, y, based){
    ctx.fillStyle = based ? "#0c0" : "#c00";
    ctx.beginPath()
    ctx.arc(
        drawnToRealX(x, valueOfR()), drawnToRealY(y, valueOfR()),
        5, 0, 2 * Math.PI, true
    );
    ctx.fill();
}

function placeAllDots() {
    $("#previous-results>tbody tr").each(function(i, element) {
        const self = $(this);
        if(self.hasClass("no-records")) return;
        const x = self.find(".x").text().trim();
        const y = self.find(".y").text().trim();
        const hit = self.find(".hit").text().trim() === "база" ? true : false;
        console.log("x: "+x+"; y: "+y+"; hit: "+hit)
        dot(x, y, hit);
    })
}

function redrawPlot() {
    ctx.clearRect(0, 0, width, height)
    ctx.beginPath()
    ctx.fillStyle = "#0077ff7f"
    // Отрисовка и заливка области
    ctx.arc(width / 2, height / 2, radius, 3 * Math.PI / 2, Math.PI, true)
    ctx.lineTo(width / 2, height / 2)
    ctx.lineTo(width / 2, height / 2 + radius)
    ctx.lineTo(width / 2 + radius / 2, height / 2 + radius)
    ctx.lineTo(width / 2 + radius / 2, height / 2)
    ctx.lineTo(width / 2, height / 2 - radius)
    ctx.fill()

    ctx.beginPath()
    ctx.strokeStyle = "#fff"
    // Отрисовка осей
    ctx.moveTo(width / 2, 0)
    ctx.lineTo(width / 2, height)
    ctx.moveTo(0, height / 2)
    ctx.lineTo(width, height / 2)
    // Отрисовка засечек по X
    ctx.moveTo(width / 2 - radius, height / 2 - radius / 20)
    ctx.lineTo(width / 2 - radius, height / 2 + radius / 20)
    ctx.moveTo(width / 2 - radius / 2, height / 2 - radius / 20)
    ctx.lineTo(width / 2 - radius / 2, height / 2 + radius / 20)
    ctx.moveTo(width / 2 + radius / 2, height / 2 - radius / 20)
    ctx.lineTo(width / 2 + radius / 2, height / 2 + radius / 20)
    ctx.moveTo(width / 2 + radius, height / 2 - radius / 20)
    ctx.lineTo(width / 2 + radius, height / 2 + radius / 20)
    // Отрисовка засечек по Y
    ctx.moveTo(width / 2 - radius / 20, height / 2 - radius)
    ctx.lineTo(width / 2 + radius / 20, height / 2 - radius)
    ctx.moveTo(width / 2 - radius / 20, height / 2 - radius / 2)
    ctx.lineTo(width / 2 + radius / 20, height / 2 - radius / 2)
    ctx.moveTo(width / 2 - radius / 20, height / 2 + radius / 2)
    ctx.lineTo(width / 2 + radius / 20, height / 2 + radius / 2)
    ctx.moveTo(width / 2 - radius / 20, height / 2 + radius)
    ctx.lineTo(width / 2 + radius / 20, height / 2 + radius)
    ctx.stroke()
    let r = valueOfR()
    // Отрисовка текста
    ctx.fillStyle = "#fff"
    ctx.font = "18px monospace"
    ctx.fillText("X", width - 18, height / 2)
    ctx.fillText("Y", width / 2, 18)
    ctx.fillText(r !== "" ? -r : "-R", width / 2 - radius, height / 2)
    ctx.fillText(r !== "" ? -r / 2 : "-R/2", width / 2 - radius / 2, height / 2)
    ctx.fillText(r !== "" ? r / 2 : "R/2", width / 2 + radius / 2 - 36, height / 2)
    ctx.fillText(r !== "" ? r : "R", width / 2 + radius - 18, height / 2)
    ctx.fillText(r !== "" ? r : "R", width / 2, height / 2 - radius + 18)
    ctx.fillText(r !== "" ? r / 2 : "R/2", width / 2, height / 2 - radius / 2 + 18)
    ctx.fillText(r !== "" ? -r / 2 : "-R/2", width / 2, height / 2 + radius / 2 + 18)
    ctx.fillText(r !== "" ? -r : "-R", width / 2, height / 2 + radius + 18)
}

redrawPlot()
placeAllDots()
document.getElementsByName("dotForm")[0].elements["r"].forEach (function (element) {
    element.onclick = function() {
        redrawPlot()
        placeAllDots()
    }
})

function submit(action, method, values) {
    var form = $('<form/>', {
        action: action,
        method: method
    });
    $.each(values, function() {
        form.append($('<input/>', {
            type: 'hidden',
            name: this.name,
            value: this.value
        }));
    });
    form.appendTo('body').submit();
}

plot.onclick = function onPlotShoot(e) {
    let r = valueOfR()
    if (r !== "") {
        let rect = e.target.getBoundingClientRect()
        let x = realToDrawnX(e.clientX - rect.left, r)
        let y = realToDrawnY(e.clientY - rect.top, r)
        console.log("x: " + x + "; y: " + y + "; r : " + r)
        submit('control', 'POST', [
            { name: 'x', value: x },
            { name: 'y', value: y },
            { name: 'r', value: r },
            { name: 'strict', value: 'false'},
        ])
    } else {
        alert("Невозможно произвести выстрел. Выберите радиус (R) и повторите попытку.")
    }
}