const questions = [
    {
        question: "Java is a ?",
        options: ["OS", "Programming Language", "Browser"],
        answer: "b"
    },
    {
        question: "Which one is a loop?",
        options: ["If", "For", "Break"],
        answer: "b"
    },
    {
        question: "HTML stands for?",
        options: ["Hyper Text Markup Language", "High Tech Modern Language", "Home Tool Markup Language"],
        answer: "a"
    },
    {
        question: "CSS is used for?",
        options: ["Programming", "Styling", "Database"],
        answer: "b"
    },
    {
        question: "Which is a JavaScript framework?",
        options: ["Python", "React", "MySQL"],
        answer: "b"
    }
];

let current = 0;
let score = 0;
let answered = false;

const questionEl = document.getElementById("question");
const optionsEl = document.getElementById("options");
const resultEl = document.getElementById("result");
const nextBtn = document.getElementById("nextBtn");
const counterEl = document.getElementById("counter");
const progressEl = document.getElementById("progress");

loadQuestion();

function loadQuestion() {
    const q = questions[current];
    
    questionEl.textContent = q.question;
    resultEl.textContent = "";
    nextBtn.style.display = "none";
    answered = false;
    
    // Update counter and progress
    counterEl.textContent = `Question ${current + 1} of ${questions.length}`;
    progressEl.style.width = `${((current) / questions.length) * 100}%`;
    
    // Clear and create new option buttons
    optionsEl.innerHTML = "";
    
    const choices = ['a', 'b', 'c'];
    q.options.forEach((option, index) => {
        const button = document.createElement("button");
        button.className = "option";
        button.textContent = `${choices[index].toUpperCase()}) ${option}`;
        button.onclick = () => checkAnswer(choices[index], button);
        optionsEl.appendChild(button);
    });
}

function checkAnswer(choice, buttonEl) {
    if (answered) return; // Prevent multiple answers
    
    answered = true;
    const correct = questions[current].answer;
    
    // Disable all buttons
    const allButtons = document.querySelectorAll(".option");
    allButtons.forEach(btn => btn.disabled = true);
    
    if (choice === correct) {
        resultEl.textContent = "✅ Correct!";
        resultEl.className = "correct";
        buttonEl.classList.add("correct");
        score++;
    } else {
        resultEl.textContent = "❌ Wrong!";
        resultEl.className = "wrong";
        buttonEl.classList.add("wrong");
        
        // Highlight the correct answer
        allButtons.forEach((btn, idx) => {
            if (['a', 'b', 'c'][idx] === correct) {
                btn.classList.add("correct");
            }
        });
    }
    
    nextBtn.style.display = "block";
}

function nextQuestion() {
    current++;
    
    if (current < questions.length) {
        loadQuestion();
    } else {
        showResults();
    }
}

function showResults() {
    const percentage = Math.round((score / questions.length) * 100);
    
    questionEl.textContent = "🎉 Quiz Completed!";
    optionsEl.innerHTML = "";
    
    let emoji = "🌟";
    let message = "Great job!";
    
    if (percentage === 100) {
        emoji = "🏆";
        message = "Perfect score!";
    } else if (percentage >= 80) {
        emoji = "🎯";
        message = "Excellent work!";
    } else if (percentage >= 60) {
        emoji = "👍";
        message = "Good effort!";
    } else {
        emoji = "📚";
        message = "Keep practicing!";
    }
    
    resultEl.innerHTML = `
        <div class="final-score">
            <div class="score-emoji">${emoji}</div>
            <div class="score-text">${message}</div>
            <div class="score-number">Your Score: ${score}/${questions.length}</div>
            <div class="score-percentage">${percentage}%</div>
        </div>
    `;
    resultEl.className = "";
    
    progressEl.style.width = "100%";
    nextBtn.textContent = "Restart Quiz";
    nextBtn.onclick = restartQuiz;
    nextBtn.style.display = "block";
}

function restartQuiz() {
    current = 0;
    score = 0;
    answered = false;
    nextBtn.textContent = "Next Question →";
    nextBtn.onclick = nextQuestion;
    loadQuestion();
}
