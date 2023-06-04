import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.AssertJUnit.assertEquals;
import static com.codeborne.selenide.Selectors.byAttribute;

public class MartspecTagsTest {

    @BeforeAll
    public static void setUp() {
        // Настройка Selenide
        Configuration.baseUrl = "https://martspec.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void testMartSpecPages() {
        String[] pageUrls = {
                "/ru",
                "/ru/about",
                "/ru/privacy-policy",
                "/ru/mission",
                "/ru/team",
                "/ru/bodymass",
                "/ru/bodyzinc",
                "/ru/bodysize",
                "/ru/electrolyte",
                "/ru/emotion",
                "/ru/waistline",
                "/ru/vitamin"

        };

        String[] expectedTitles = {
                "Martspec — трекер твоего здоровья",
                "О нас | Martspec",
                "Политика конфиденциальности | Martspec",
                "Наша миссия | Martspec",
                "Наша команда | Martspec",
                "Вес — самый удобный и простой трекер веса",
                "Цинк – трекер для Apple Watch",
                "Фигура — помощник на пути к идеальному телу.",
                "Electrolyte - Учет электролитов организма",
                "Эмоция — покажет, что ты чувствуешь",
                "Талия – дневник измерений всегда под рукой",
                "Витамин – трекер сбалансированного и здорового питания"
        };

        String[] expectedDescriptions = {
                "Приложения для тех, кто заботится о своём здоровье. Удобный и простой способ следить за параметрами тела и своим эмоциональным состоянием.",
                "С 2020 года мы создаем приложения с использованием передовых технологий, которые помогают вам оставаться здоровыми и счастливыми.",
                "Защита вашей личной информации — наш основной приоритет. На данной странице описана наша политика в отношении сбора, использования и раскрытия вашей информации.",
                "Мы хотим, чтобы каждый мог быстро и легко следить за своим здоровьем и самочувствием.",
                "Команда Martspec  — инженеры, дизайнеры и копирайтеры, которые создают лучшие приложения для здоровья.",
                "Трекер веса помогает повысить эффективность тренировок, а также скорректировать питание. Простое приложение Apple Watch с поддержкой Apple Health.",
                "Цинк укрепляет иммунитет, стабилизирует уровень гормонов и помогает регулировать аппетит. Лучший трекер цинка для Apple Watch.",
                "Индивидуальные измерения тела и биоритмы. Отслеживайте важные для вас параметры тела и биоритмы. Поддержка показателей формы тела, потребности в энергии, ИМТ и многое другое.",
                "Электролиты — важные компоненты организма. Легко контролируйте их с помощью нашего приложения для Apple Watch, полная интеграция с Apple Health.",
                "Перепады настроения? Эмоциональные качели? Выясните основную причину всего за 1 минуту.",
                "Простое в использовании приложение Apple Watch для записи объема талии. Полная поддержка Apple Health.",
                "Отслеживайте витамины, минералы и другие добавки на Apple Watch, iPhone, iPad или Mac с помощью нашего удобного приложения. Бесплатная синхронизация данных с Apple Health."
        };


        for (int i = 0; i < pageUrls.length; i++) {
            String pageUrl = pageUrls[i];
            String expectedTitle = expectedTitles[i];
            String expectedDescription = expectedDescriptions[i];

            Selenide.open(pageUrl);

            // Проверка заголовка страницы
            assertEquals(expectedTitle, Selenide.title());

            // Проверка тега "description"
            String actualDescription = $(By.cssSelector("meta[name='description']")).getAttribute("content");
            assertEquals(expectedDescription, actualDescription);

            // Проверка тега "og:description"
            String actualOgDescription = $(By.cssSelector("meta[property='og:description']")).getAttribute("content");
            assertEquals(expectedDescription, actualOgDescription);
        }
    }
}