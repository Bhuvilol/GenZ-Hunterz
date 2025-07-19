# GenZ-Hunterz

Welcome to **GenZ-Hunterz** — a fun, retro-inspired 2D adventure game made with Java! Explore battle monsters, collect loot, and uncover secrets in a pixel-art world.

---

<img width="1920" height="1080" alt="photo-collage png" src="https://github.com/user-attachments/assets/9e3452ce-c63c-464e-bb9b-06b201f007e4" />

## 🌟 What's Inside?
- **Classic 2D Adventure:** Top-down gameplay with a nostalgic vibe.
- **Choose Your Hero:** Play as a Fighter, Rogue, or Sorcerer — each with their own style.
- **Meet NPCs & Merchants:** Chat, trade, and discover stories.
- **Collect & Upgrade:** Find coins, keys, potions, and powerful equipment.
- **Face Monsters & Bosses:** Test your skills against a variety of enemies.
- **Inventory System:** Manage your gear and items.
- **Customizable Controls & Fullscreen.**

---

## 🎮 Controls
- **WASD:** Move
- **ENTER:** Interact / Confirm
- **SPACE:** Attack
- **F:** Shoot projectile (if you have one)
- **C:** Character screen
- **P:** Pause
- **ESC:** Back / Cancel / Options menu
- **Arrow Keys:** Navigate menus and inventory
- **T:** Toggle debug text (developer mode)
- **R:** Reload current map (developer mode)

---

## 🚀 How to Play

Just Download the `GenzHunterz.jar` and play

OR

1. **Install Java 17+** if you don't have it already.
2. **Download or clone** this repo.
3. **Start the game:**
   ```
   java -jar GenzHunterz.jar
   ```
4. **Have fun!**

> **Note:** The latest version includes fixes for configuration and map loading issues. The game should now run smoothly without crashes.

---

## 🛠️ Building from Source
Want to tinker or contribute? Here's how to build it yourself:
1. Compile the Java files:
   ```
   javac -d out -sourcepath main/java main/java/tech/fallqvist/Main.java
   ```
2. Copy the resources:
   ```
   xcopy /E /I /Y main\resources out\main\resources
   ```
3. Package everything into a JAR:
   ```
   jar --create --file GenzHunterz.jar --main-class=tech.fallqvist.Main -C out .
   ```

---

## 📜 Game Tips
- Explore everywhere — you never know what you'll find!
- Talk to everyone. NPCs can help or surprise you.
- Collect coins, keys, and potions to progress.
- Some doors and chests need keys.
- Upgrade your gear to survive tougher battles.
- Keep an eye on your health and mana.
- Most importantly: enjoy the adventure!

---

## 🤝 Contributing
We love new ideas and improvements! If you want to help:
1. Fork this repo
2. Create a feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes
4. Push to your branch
5. Open a pull request

If you have questions or want to discuss an idea, open an issue or start a conversation.

---

## 📄 License
This project is open source and available under the MIT License.

---

Thanks for checking out GenZ-Hunterz. Have fun, and happy coding! 🎉
