<div align="center">
  <img src="https://github.com/aric1605/Alarm_Application/blob/b89eac7ea5a827d46a5f1989bd67e0024395b36f/banner.png" alt="Know Your Leader Banner" width="40%" height="40%" />
  <h1>⏰ Alarm Quiz App</h1>
  <p><strong>> A smart alarm app that *literally forces you to wake up your brain* before your body. Say goodbye to snoozing with our arithmetic challenge alarm! 💥📱</strong></p>
  <br />
  <p>
    <a href="https://github.com/aric1605/Alarm_Application"><img alt="GitHub stars" src="https://img.shields.io/github/stars/aric1605/Alarm_Application?style=social"></a>
    <a href="https://github.com/aric1605/Alarm_Application/issues"><img alt="GitHub issues" src="https://img.shields.io/github/issues/aric1605/Alarm_Application?color=blue"></a>
  </p>
</div>

---

![Kotlin](https://img.shields.io/badge/Kotlin-1.9-blueviolet?style=flat&logo=kotlin)
![Android](https://img.shields.io/badge/Android-7.0+-green?style=flat&logo=android)
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

## 📦 Download & Try

[![Download APK](https://img.shields.io/badge/Download-APK-blue?style=for-the-badge&logo=android)](https://drive.google.com/file/d/1r6N0QPFWNqQOOoXvz33Zx0h9evfF6RgR/view?usp=sharing)

---

### Installation

```bash
git clone https://github.com/aric1605/Alarm_Application.git
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
├── AlarmActivity.kt         # Displays quiz to dismiss alarm And Generates questions and handles logic
├── res/
│   └── layout/
│       ├── activity_main.xml
│       ├── activity_alarm.xml
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

---


## ❤️ Credits & Inspiration

Built by sleep-deprived developers who were tired of oversleeping 😴

> _"Wake up, solve math, conquer the day!"_

---

## 📬 Feedback

Have suggestions or found a bug?

- Drop an email: aricvasaya10@gmail.com
- Connect with me on [Linkdin](https://www.linkedin.com/in/aric-vasaya-a7a0b1287/)
- [GitHub Repository](https://github.com/aric1605/Alarm_Application)
- [Report Issues](https://github.com/aric1605/Alarm_Application/issues)
- [Contributing Guide](CONTRIBUTING.md)

---

<div align="center"> <br /> <b>⭐ Star the repo to support the project!</b> <br /><br /> <img src="https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExaWR3eDBrMDF5ZnUyYmJlOXFlYTVncmJoajgwMTRtdGszcDBpa2x3YiZlcD12MV9naWZzX3NlYXJjaCZjdD1n/l4FGGafcOHmrlQxG0/giphy.gif" width="250px" alt="Thank You!" /> </div>


Made with ❤️ and ☕ by Aric
