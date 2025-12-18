# Quiz Application

A simple quiz application available in two versions: **Web (HTML/CSS/JavaScript)** and **Java (Console-based)**.

## Features

✨ **Multiple choice questions** with A, B, C options  
✅ **Instant feedback** on answers  
📊 **Score tracking** throughout the quiz  
🎯 **Final results** with percentage and performance message  
🎨 **Modern UI** (Web version)  
💾 **File-based questions** - easy to add/edit questions

---

## Web Version (HTML/CSS/JavaScript)

### How to Run

1. Make sure all files are in the same folder:
   - `index.html`
   - `style.css`
   - `script.js`

2. Open `index.html` in any web browser (Chrome, Firefox, Safari, Edge)

3. Answer the questions by clicking on the options

### Features

- Beautiful gradient design with smooth animations
- Progress bar showing quiz completion
- Question counter
- Answer validation (can't select multiple answers)
- Color-coded feedback (green for correct, red for wrong)
- Shows correct answer when you get it wrong
- Final score with emoji and encouraging message
- Restart button to retake the quiz
- Fully responsive design for mobile and desktop

---

## Java Version (Console-based)

### How to Run

1. Make sure you have **Java installed** on your computer
   - Check by running: `java -version`

2. Place these files in the same folder:
   - `quiz.java`
   - `questions.txt`

3. **Compile** the program:
   ```bash
   javac quiz.java
   ```

4. **Run** the program:
   ```bash
   java quiz
   ```

5. Answer questions by typing `a`, `b`, or `c` and pressing Enter

### Features

- Clean console interface with separators
- Shows correct answer when wrong
- Final score with percentage
- Performance message based on score
- Error handling for file issues
- Skips malformed lines in questions file

---

## Questions File Format

Both versions can use questions from `questions.txt`. Format:

```
Question text|A) Option1,B) Option2,C) Option3|correct_answer
```

**Example:**
```
Java is a ?|A) OS,B) Programming Language,C) Browser|b
Which one is a loop?|A) If,B) For,C) Break|b
```

### Rules:
- Each question on a new line
- Use `|` (pipe) to separate: question, options, and answer
- Use `,` (comma) to separate options
- Answer should be `a`, `b`, or `c` (lowercase)
- Format: `A) text`, `B) text`, `C) text`

---

## Adding Your Own Questions

### For Web Version:

**Option 1:** Edit `script.js` (easier for beginners)

Find the `questions` array and add more questions:

```javascript
const questions = [
    {
        question: "Your question here?",
        options: ["Option A", "Option B", "Option C"],
        answer: "b"  // a, b, or c
    },
    // Add more questions...
];
```

**Option 2:** Load from file (requires a local server)

You can modify the code to load questions from `questions.txt` using fetch API.

### For Java Version:

Simply edit `questions.txt` following the format above. The program automatically reads all questions from the file.

---

## Customization Ideas

### Web Version:
- Change colors in `style.css` (look for color values like `#667eea`)
- Modify fonts by changing the Google Fonts import
- Add a timer for each question
- Add sound effects for correct/wrong answers
- Add difficulty levels
- Store high scores in localStorage

### Java Version:
- Add a timer using `System.currentTimeMillis()`
- Add difficulty levels with different question files
- Save scores to a file
- Add user login/profiles
- Shuffle questions randomly

---

## File Structure

```
quiz-app/
│
├── index.html          # Web version - main HTML file
├── style.css           # Web version - styling
├── script.js           # Web version - functionality
├── quiz.java           # Java version - main program
├── questions.txt       # Questions database (for Java)
└── README.md          # This file
```

---

## Troubleshooting

### Web Version:
- **Page looks broken:** Make sure all 3 files (HTML, CSS, JS) are in the same folder
- **Buttons don't work:** Check browser console (F12) for JavaScript errors
- **Styling missing:** Ensure `style.css` filename matches the link in HTML

### Java Version:
- **"questions.txt not found":** Make sure the file is in the same directory where you run the program
- **"javac not recognized":** Install Java JDK and add it to your PATH
- **Compilation errors:** Make sure the file is named exactly `quiz.java`

---

## Credits

Created as a learning project for building interactive quiz applications.

Feel free to modify and enhance! 🚀
