window.onload = function calculate(){

    let totalCalories = document.getElementById("totalCalories").innerText;

    let running = document.getElementById("running");
    let walking = document.getElementById("walking");
    let cycling = document.getElementById("cycling");
    let swimming = document.getElementById("swimming");

    running = Math.floor(totalCalories/15);
    walking = Math.floor(totalCalories/8);
    cycling = Math.floor(totalCalories/9);
    swimming = Math.floor(totalCalories/10);

    document.getElementById("running").innerText="Running for " + toHoursAndMinutes(running);
    document.getElementById("walking").innerText="Walking for " + toHoursAndMinutes(walking);
    document.getElementById("cycling").innerText="Cycling for " + toHoursAndMinutes(cycling);
    document.getElementById("swimming").innerText="Swimming for " + toHoursAndMinutes(swimming);

}

//15 cal - running 1min
//8 cal - walking 1min
//9 cal - cycling 1min
//10 cal - swimming 1min

function toHoursAndMinutes(totalMinutes) {
    const minutes = totalMinutes % 60;
    const hours = Math.floor(totalMinutes / 60);

    return `${padTo2Digits(hours)}hr and ${padTo2Digits(minutes)} mins`;
}

function padTo2Digits(num) {
    return num.toString().padStart(2, '0');
}

