const MIN_Y = -3
const MAX_Y = 5
function validate() {
    let y = document.forms[0].elements["y"].value
    if (typeof +y !== 'number' || !isFinite(+y) || isNaN(+y)) {
        alert("Значение координаты Y должно быть числом. Повторите попытку.")
        return false
    }

    if (!(y >= MIN_Y + 1 && y <= MAX_Y - 1) && !y.startsWith("-2.") && !y.startsWith("4.")) {
        alert("Значение координаты Y должно входить в диапазон ("+MIN_Y+" .."+MAX_Y+") (не включая " +
            "граничные значения). Повторите попытку.")
        return false
    }

    if(valueOfR() === "") {
        alert("Выбрано 0 или несколько значений R. Пожалуйста, выберите ровно одно и повторите попытку.")
        return false
    }

    return true
}