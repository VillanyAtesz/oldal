function kerelem(metodus, url, tartalom){
    const xhr = new XMLHttpRequest();

    xhr.open(metodus, url, 0);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(tartalom));

    if(xhr.status == 200){
        if(xhr.responseText.length != 0){
            return JSON.parse(xhr.responseText);
        }
    }else{
        alert("Hiba - " + xhr.status + ": " + xhr.responseText);
        throw {status: xhr.status, response: xhr.responseText};
    }
}