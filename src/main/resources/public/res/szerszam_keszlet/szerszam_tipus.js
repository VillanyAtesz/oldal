(function szerszamTipusokBetoltese(){
    const szerszamTipusok = kerelem("GET", "/szerszam-tipusok");

    const input = document.getElementById("szerszam-tipus");
        const valasszOption = document.createElement("option");
            valasszOption.value = "";
            valasszOption.innerHTML = "Válassz";
    input.appendChild(valasszOption);

    szerszamTipusok.sort((a, b) => a.megnevezes.localeCompare(b.megnevezes));

    szerszamTipusok.forEach(szerszamTipus => {
        const option = document.createElement("option");
            option.value = szerszamTipus.id;
            option.innerText = szerszamTipus.megnevezes;
        input.appendChild(option);
    });
})();