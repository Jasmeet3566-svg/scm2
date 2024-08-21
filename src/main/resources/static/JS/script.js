console.log("Script loaded");

let currentTheme = getTheme();

changeTheme(currentTheme);

function changeTheme(currentTheme) {
    // Apply the current theme to the HTML element
    document.querySelector('html').classList.add(currentTheme);
    console.log("Theme applied:", currentTheme);

    // Set the listener for the theme change button
    const changeThemeButton = document.querySelector('#theme_change_button');
    const themeText = document.querySelector('#theme_text'); // Add this line

    // Update the text based on the current theme
    updateThemeText(currentTheme);

    changeThemeButton.addEventListener("click", () => {
        // Remove the current theme
        document.querySelector('html').classList.remove(currentTheme);

        // Toggle the theme between dark and light
        if (currentTheme === "dark") {
            currentTheme = "light";
        } else {
            currentTheme = "dark";
        }

        // Apply the new theme
        setTheme(currentTheme);
        document.querySelector('html').classList.add(currentTheme);

        // Update the text based on the new theme
        updateThemeText(currentTheme);
    });
}

function updateThemeText(currentTheme) {
    const themeText = document.querySelector('#theme_text');
    themeText.textContent = currentTheme.charAt(0).toUpperCase() + currentTheme.slice(1); // Capitalize the first letter
}

function setTheme(theme) {
    // Save the theme to localStorage
    localStorage.setItem('theme', theme);
}

function getTheme() {
    // Retrieve the theme from localStorage, default to 'light'
    let theme = localStorage.getItem('theme');
    return theme ? theme : 'light';
}
