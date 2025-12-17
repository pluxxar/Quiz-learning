const questions = [
    {
        question: "Java is a ?",
        answer: "b"
    },
    {
        question: "Which one is a loop?",
        answer: "b"
    }
];

let current = 0;
let score = 0;

const questionEl = document.getElementById("question");
const resultEl = document.getElementById("result");
const nextBtn = document.getElementById("nextBtn");

loadQuestion();

function loadQuestion() {
    questionEl.textContent = questions[current].question;
    resultEl.textContent = "";
    nextBtn.style.display = "none";
}

function checkAnswer(choice) {
    if (choice === questions[current].answer) {
        resultEl.textContent = "Correct ✅";
        score++;
    } else {
        resultEl.textContent = "Wrong ❌";
    }
    nextBtn.style.display = "block";
}

function nextQuestion() {
    current++;
    if (current < questions.length) {
        loadQuestion();
    } else {
        questionEl.textContent = "Quiz Finished!";
        resultEl.textContent = "Your Score: " + score;
        nextBtn.style.display = "none";
    }
}
