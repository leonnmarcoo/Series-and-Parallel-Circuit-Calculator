<div align="center">
  <h1>⚡ Series and Parallel Circuit Calculator</h1>
</div>

> **Three resistors, one voltage, every answer.**  
> A JavaFX desktop app that solves three-resistor series and parallel circuits, built as our final project in College Physics 2.

---

## 🔌 What Does It Do?

Pick a circuit, type in **R₁, R₂, R₃** and the total voltage **V(t)**, then hit **CALCULATE**. The app fills in the rest right on the circuit diagram:

- 🧮 Total resistance **R(t)**
- 🌊 Total current **I(t)**
- ➡️ Current through each resistor **I₁, I₂, I₃**
- 🔋 Voltage across each resistor **V₁, V₂, V₃**

The landing page doubles as a quick lesson on Ohm's Law and how series and parallel circuits differ. Once you're in, a button at the top lets you hop between the two circuit types.

---

## 📐 The Physics

| | Series | Parallel |
| --- | --- | --- |
| **Total resistance** | R₁ + R₂ + R₃ | 1 ÷ (1/R₁ + 1/R₂ + 1/R₃) |
| **Current** | V(t) ÷ R(t), the same through every resistor | Iₙ = V(t) ÷ Rₙ, and I(t) = I₁ + I₂ + I₃ |
| **Voltage** | Vₙ = I(t) × Rₙ | V(t) across every resistor |

### Try It Out

Here's what you get for **R₁ = 10 Ω, R₂ = 20 Ω, R₃ = 30 Ω** at **12 V**:

| | Series | Parallel |
| --- | --- | --- |
| **R(t)** | 60.00 Ω | 5.45 Ω |
| **I(t)** | 0.20 A | 2.20 A |
| **I₁, I₂, I₃** | 0.20 A, 0.20 A, 0.20 A | 1.20 A, 0.60 A, 0.40 A |
| **V₁, V₂, V₃** | 2.00 V, 4.00 V, 6.00 V | 12.00 V, 12.00 V, 12.00 V |

### Good to Know

- ✅ Blank or non-numeric input pops up an **Invalid Input** alert.
- ⚠️ Zero isn't caught. A resistance of 0 can show `Infinity` or `NaN` in the results, so stick to positive values.
- 🔢 The app always expects exactly three resistors.

---

## 📸 A Look Inside

The landing page:

<div align="center">
  <img src="src/Images/Landing%20Page.png" alt="Landing page with circuit choices, Ohm's Law, and explanations of series and parallel circuits" width="420"/>
</div>

The series and parallel page artwork. In the app, the input fields sit on the glowing blue markers.

<div align="center">
  <img src="src/Images/Series%20Page.png" alt="Series circuit diagram with three resistors and a battery on a dark background" width="420"/>
  <img src="src/Images/Parallel%20Page.png" alt="Parallel circuit diagram with three resistors and a battery on a dark background" width="420"/>
</div>

---

## 🛠️ Tech Stack

| | |
| --- | --- |
| **Language** | Java |
| **UI** | JavaFX 23.0.2, FXML, and CSS |
| **Tools** | Scene Builder, Figma, and VS Code |

---

## 🚀 How to Run

### macOS on Apple Silicon

The repo already includes JavaFX and compiled classes, so all you need is **JDK 24 or newer**:

```bash
git clone https://github.com/leonnmarcoo/Series-and-Parallel-Circuit-Calculator.git
cd Series-and-Parallel-Circuit-Calculator
java --module-path lib --add-modules javafx.controls,javafx.fxml -cp bin Main
```

### Everything Else

The JavaFX files in `lib/` only work on Apple Silicon Macs. On another platform, or with an older JDK, download the [JavaFX 23 SDK](https://gluonhq.com/products/javafx/) for your system, use JDK 21 or newer, and rebuild. Replace `/path/to/javafx-sdk/lib` with the location of the SDK's `lib` folder:

```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -d bin $(find src -name '*.java')
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp bin Main
```

### VS Code

Update the `--module-path` in `vmArgs` in `.vscode/launch.json` to point at your JavaFX `lib` folder, then run the **Main** configuration.

---

## 🤝 The Team

- Leon Marco A. Devela
- Jared L. Pilapil
- Jersey Mae D. Marisga
- John Mikael D. Evangelista
- Tristan Jay M. Sevilla

Submitted to Mr. Raul B. Borlungay.
