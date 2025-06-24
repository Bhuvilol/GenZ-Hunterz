# GenZ-Hunterz

Welcome to **GenZ-Hunterz** — a fun, retro-inspired 2D adventure game made with Java! Explore battle monsters, collect loot, and uncover secrets in a pixel-art world.

---


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
- **ESC:** Back / Cancel (in menus)

---

## 🚀 How to Play
1. **Install Java 17+** if you don't have it already.
2. **Download or clone** this repo.
3. Use the included `GenzHunterz.jar` or build your own (see below).
4. **Start the game:**
   ```
   java -jar GenzHunterz.jar
   ```
5. **Have fun!**

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