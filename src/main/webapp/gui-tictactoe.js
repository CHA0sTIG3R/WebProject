(function(calculateWinner) {

    const x = document.querySelectorAll("#tictactoe tbody td");
    const tds = [...x];
    let isX = true;
    isWinner = false;
    const message = document.getElementById("message");
    const btnReset = document.getElementById("btnReset");

    tds.forEach(td => {
        td.addEventListener("click", () => {
            play(td);
        });
    })

    function reset() {
        tds.forEach(e => {
            e.innerText = "N"
            e.classList.remove("winner");
        });
        message.innerText = "";
        isWinner = false;
    }

    btnReset.addEventListener("click", reset);

    function play(pThis) {
        if (isWinner) {
            message.innerText = "You won already, what are you doing?";
            return;
        }
        message.innerText = "";
        if (pThis.innerText != "N") {
            message.innerText = "Stop Cheating!";
            return;
        }

        console.log("playing");
        pThis.innerText = isX ? "X" : "O";
        isX = !isX;

        data = tds.map(e => e.innerText);

        let status = calculateWinner(data);
        if (status.isWinner) {
            let [p1, p2, p3] = status.winningCombo;
            tds[p1].classList.add("winner");
            tds[p2].classList.add("winner");
            tds[p3].classList.add("winner");
            message.innerText = "The Winner is " + status.whoWon;
            isWinner = true;
        }
    }
})(window.citytech.getWinner)