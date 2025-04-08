# ⏰ Alarm Quiz App

> A smart alarm app that *literally forces you to wake up your brain* before your body. Say goodbye to snoozing with our arithmetic challenge alarm! 💥📱

---

![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blueviolet?style=flat&logo=kotlin)
![Android](https://img.shields.io/badge/Android-7.0+-green?style=flat&logo=android)
![License](https://img.shields.io/github/license/yourusername/alarm-quiz-app)
![Contributions](https://img.shields.io/badge/contributions-welcome-orange)

---

## 📲 Features

- 🔔 **Alarm That Won't Quit** — The alarm will *not* stop unless you solve the quiz.
- 🧮 **10-Question Arithmetic Quiz** — Solve random addition & subtraction problems using numbers from 1–100.
- 📢 **Maximum Volume + Looping Alarm** — Your default alarm sound plays in a loop at full blast.
- 📳 **Vibrations Enabled** — Your phone buzzes aggressively along with the alarm.
- 🔒 **Screen Lock & Wake Lock** — Prevents the screen from sleeping and disables back presses.
- 🎨 **Modern UI** — Gradient backgrounds and animated transitions for a pleasant look.
- 🧠 **Quiz ViewModel Support** — Well-structured architecture using MVVM pattern.
- 🗃 **Room DB Integration (WIP)** — Track your quiz history and accuracy (coming soon!).

---

## 🚀 Getting Started

### Requirements
- Android Studio **Flamingo** or newer
- Kotlin **1.9+**
- Android SDK **24+ (Nougat)**

### Installation

```bash
git clone https://github.com/yourusername/alarm-quiz-app.git
cd alarm-quiz-app
```

Open the project in Android Studio and click **Run ▶️**.

---

## 🧠 How It Works

1. **Set the Alarm**: User picks a time using the TimePicker.
2. **Broadcast Receiver**: `AlarmReceiver` receives the signal and triggers the service.
3. **Foreground Alarm Service**: `AlarmService` starts playing a looping alarm and vibration.
4. **Quiz Launch**: `AlarmActivity` pops up with a mandatory 10-question quiz.
5. **Victory**: Solve the quiz to stop the noise and vibrations.

---

## 🗂 Project Structure

```text
com.aric.alarm_application/
├── MainActivity.kt          # Set alarm using TimePicker
├── AlarmReceiver.kt         # Receives and starts alarm service
├── AlarmService.kt          # Plays alarm sound and vibration
├── AlarmActivity.kt         # Displays quiz to dismiss alarm
├── QuizViewModel.kt         # Generates questions and handles logic
├── res/
│   └── layout/
│       ├── activity_main.xml
│       ├── activity_alarm.xml
│       └── quiz_question_item.xml
└── AndroidManifest.xml
```

---

## 🔐 Permissions Required

| Permission | Purpose |
|------------|---------|
| `SCHEDULE_EXACT_ALARM` | Required to trigger exact alarms |
| `WAKE_LOCK`            | Keeps screen on during alarm ring |
| `FOREGROUND_SERVICE`   | Required to run ringtone in foreground |
| `VIBRATE`              | Enables vibration with the alarm |


---

## 🛠 Future Enhancements

- [ ] Snooze feature with customizable duration
- [ ] Room Database integration for quiz history
- [ ] Leaderboard for fastest quiz completions
- [ ] Themes (Light / Dark / AMOLED)
- [ ] Add custom alarm sounds and ringtones
- [ ] Support for multiplication/division questions

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

```bash
git checkout -b feature/your-feature-name
git commit -m "Add new feature"
git push origin feature/your-feature-name
```

---


## ❤️ Credits & Inspiration

Built by sleep-deprived developers who were tired of oversleeping 😴

> _"Wake up, solve math, conquer the day!"_

---

### 🌐 Links

- [GitHub Repository](https://github.com/aric1605/Alarm_Application)
- [Report Issues](https://github.com/aric1605/Alarm_Application/issues)
- [Contributing Guide](CONTRIBUTING.md)

---

Made with ❤️ and ☕ by Team Aric
