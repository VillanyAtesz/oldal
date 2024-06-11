function letrehozas(){
    const szerszamTipusInput = document.getElementById("szerszam-tipus");
    const markaInput = document.getElementById("marka");
    const megnevezesInput = document.getElementById("megnevezes");

    const szerszamTipus = szerszamTipusInput.value;
    const marka = markaInput.value;
    const megnevezes = megnevezesInput.value;

    if(szerszamTipus == ""){
        alert("Válassz szerszám típust!");
        return;
    }

    const adat = {
        szerszamTipus: szerszamTipus,
        marka: marka
        megnevezes: megnevezes
    }

    const valasz  = kerelem("PUT", "/api/szerszam-keszlet", adat);
}