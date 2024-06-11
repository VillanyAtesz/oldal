function bejelentkezes (){
    const felhasznalonevInput = document.getElementById("felhasznalonev");
    const jelszoInput = document.getElementById("jelszo");

    const felhasznalonev = felhasznalonevInput.value;
    const jelszo = jelszoInput.value;

    if(felhasznalonev.length == 0){
        alert("Felhasználónév kitöltése kötelező!");
        return;
    }

    if(jelszo.length == 0){
        alert("Jelszó kitöltése kötelező!");
        return;
    }

    const tartalom = {
        felhasznalonev: felhasznalonev,
        jelszo: jelszo
    }

    const munkamenetAzonosito = kerelem("post", "/bejelentkezes", tartalom).ertek;

    let cookieString = "munkamenet_azonosito" + "=" + munkamenetAzonosito;
    const date = new Date();
        date.setTime(+ date + (1 * 86400000))
        cookieString += ";expires=" + date.toGMTString();


    cookieString += "; path=/";
    window.document.cookie = cookieString;

    window.location.href = "/web/home.html";
}