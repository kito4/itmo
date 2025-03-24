function countSelectedR() {
    let c = 0
    document.getElementsByName("dotForm")[0].elements["r"].forEach((element) => {
        if(element.checked) c++
    })
    return c
}

function valueOfR() {
    if (countSelectedR() !== 1) return ""
    let n = document.getElementsByName("dotForm")[0].elements["r"].length
    for (let i = 0; i < n; i++) {
        if (document.getElementsByName("dotForm")[0].elements["r"][i].checked)
            return document.getElementsByName("dotForm")[0].elements["r"][i].value
    }
}

document.getElementsByName("dotForm")[0].elements["r"].forEach(onclick = () => {
    console.log(countSelectedR()+" values selected, current value of R: "+valueOfR())
})

