
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.AssertJUnit.assertEquals;
import static com.codeborne.selenide.Selectors.byAttribute;
import static org.testng.AssertJUnit.assertTrue;

public class MartspecTagsTest {

    @BeforeAll
    public static void setUp() {
        // Настройка Selenide
        Configuration.baseUrl = "https://martspec.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void testMartSpecPagesRU() {
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
                // Landing
                "Приложения для тех, кто заботится о своём здоровье. Удобный и простой способ следить за параметрами тела и своим эмоциональным состоянием.",
                //About
                "С 2020 года мы создаем приложения с использованием передовых технологий, которые помогают вам оставаться здоровыми и счастливыми.",
                //Privacy
                "Защита вашей личной информации — наш основной приоритет. На данной странице описана наша политика в отношении сбора, использования и раскрытия вашей информации.",
                //Mission
                "Мы хотим, чтобы каждый мог быстро и легко следить за своим здоровьем и самочувствием.",
                //Team
                "Люди, стоящие за компанией, так же важны, как и сама компания. Познакомьтесь с нашими талантливыми инженерами-программистами, дизайнерами и копирайтерами, которые создают лучшие оздоровительные приложения.",
                //Body Mass
                "Трекер веса помогает повысить эффективность тренировок, а также скорректировать питание. Простое приложение Apple Watch с поддержкой Apple Health.",
                //Body Zinc
                "Цинк укрепляет иммунитет, стабилизирует уровень сахара в крови и помогает коже, глазам и сердцу оставаться здоровыми. Отслеживайте потребление цинка с помощью нашего приложения.",
                //Body Size
                "Индивидуальные измерения тела и биоритмы. Отслеживайте важные для вас параметры тела и биоритмы. Поддержка показателей формы тела, потребности в энергии, ИМТ и многое другое.",
                //Electrolyte
                "Электролиты — важные компоненты организма. Легко контролируйте их с помощью нашего приложения для Apple Watch, полная интеграция с Apple Health.",
                //Emotion
                "Перепады настроения? Эмоциональные качели? Выясните основную причину всего за 1 минуту.",
                //Waistlane
                "Простое в использовании приложение Apple Watch для записи объема талии. Полная поддержка Apple Health.",
                //Vitamin
                "Отслеживайте витамины, минералы и другие добавки на Apple Watch, iPhone, iPad или Mac с помощью нашего удобного приложения. Бесплатная синхронизация данных с Apple Health."
        };


        int errorCount = 0; // Счетчик ошибок

        for (int i = 0; i < pageUrls.length; i++) {
            String pageUrl = pageUrls[i];
            String expectedTitle = expectedTitles[i];
            String expectedDescription = expectedDescriptions[i];

            Selenide.open(pageUrl);

            try {
                // Проверка заголовка страницы
                assertEquals(expectedTitle, Selenide.title());

                // Проверка тега "description"
                String actualDescription = $(By.cssSelector("meta[name='description']")).getAttribute("content");
                assertTrue(StringUtils.replace(actualDescription, "\u00A0", " ").contains(expectedDescription));

                // Проверка тега "og:description"
                String actualOgDescription = $(By.cssSelector("meta[property='og:description']")).getAttribute("content");
                assertTrue(StringUtils.replace(actualOgDescription, "\u00A0", " ").contains(expectedDescription));
            } catch (AssertionError e) {
                errorCount++;
                System.out.println("Ошибка при проверке страницы: " + pageUrl);
                e.printStackTrace();
            }
        }

        System.out.println("Количество ошибок: " + errorCount);
    }

    @Test
    public void testMartSpecPagesEN() {
        String[] pageUrls = {
                "/en",
                "/en/about",
                "/en/privacy-policy",
                "/en/mission",
                "/en/team",
                "/en/bodymass",
                "/en/bodyzinc",
                "/en/bodysize",
                "/en/electrolyte",
                "/en/emotion",
                "/en/waistline",
                "/en/vitamin"
        };

        String[] expectedTitles = {
                // Landing
                "Simplify health & wellness tracking",
                //About
                "About | Martspec",
                //Privacy
                "Privacy Policy | Martspec",
                //Mission
                "Out Mission | Martspec",
                //Team
                "Our Team | Martspec",
                //Body Mass
                "Body Mass - The lightest weight tracker",
                //Body Zinc
                "Body Zinc - AmaZinc tracker for your watch",
                //Body Size
                "Body Size - Track body metrics to achieve health and fitness goals.",
                //Electrolyte
                "Electrolyte - Track healthy balance of essential minerals",
                //Emotion
                "Emotion - The quickest personality test",
                //Waistlane
                "Waist Size - Healthy heart, ideal body",
                //Vitamin
                "Vitamin - Track all your nutrition"
        };

        String[] expectedDescriptions = {
                // Landing
                "Control your health and happiness with beautifully simple Martspec apps. Track your physical and mental wellness with ease as your well-being improves.",
                //About
                "Since 2020, we've been creating apps using cutting-edge technology that empowers you to take charge of your personal health and wellness journey.",
                //Privacy
                "Protecting your private information is our priority. This page describes our policies and procedures on the collection, use and disclosure of your information when you use any of our mobile apps, visit our website at martspec.com or engage with us in other related ways - including sales, marketing or events.",
                //Mission
                "We make it quick and easy for everyone to track their health and wellness.",
                //Team
                "People behind company are as important as the company itself. Meet our highly talented software engineers, designers & copywriters who make the best wellness apps.",
                //Body Mass
                "Tracking your weight boosts your efficiency in terms of your time and workouts. Easy to use Apple Watch app with the full support of Apple Health.",
                //Body Zinc
                "Zinc may enhance immune function, stabilize blood sugar levels, and help your skin, eyes, and heart stay healthy.",
                //Body Size
                "Effortlessly monitor essential measurements such as chest size, shoulder width, waistline, hips, and more with the versatility of your Apple Watch, iPhone, or iPad.",
                //Electrolyte
                "Electrolytes serve as crucial components in upholding the body's homeostasis. Effortlessly monitor these vital elements with our user-friendly Apple Watch App, boasting full integration with Apple Health for optimal wellness support.",
                //Emotion
                "Unexpected mood swings? Intense emotional changes? Figure out the root cause in just 1 minute.",
                //Waistlane
                "Keep track of your waist circumference right from your wrist with the help of an easy-to-use Apple Watch app. Monitor your progress over time and enjoy full support from Apple Health.",
                //Vitamin
                "Easily track your vitamins, minerals, pills, and supplements on your Apple Watch, iPhone, iPad, or Mac with our user-friendly app. Free data sync with Apple Health."
        };

        int errorCount = 0; // Счетчик ошибок

        for (int i = 0; i < pageUrls.length; i++) {
            String pageUrl = pageUrls[i];
            String expectedTitle = expectedTitles[i];
            String expectedDescription = expectedDescriptions[i];

            Selenide.open(pageUrl);

            try {
                // Проверка заголовка страницы
                assertEquals(expectedTitle, Selenide.title());

                // Проверка тега "description"
                String actualDescription = $(By.cssSelector("meta[name='description']")).getAttribute("content");
                assertTrue(StringUtils.replace(actualDescription, "\u00A0", " ").contains(expectedDescription));

//                // Проверка тега "og:description"
//                String actualOgDescription = $(By.cssSelector("meta[property='og:description']")).getAttribute("content");
//                assertTrue(StringUtils.replace(actualOgDescription, "\u00A0", " ").contains(expectedDescription));
            } catch (AssertionError e) {
                errorCount++;
                System.out.println("Ошибка при проверке страницы: " + pageUrl);
                e.printStackTrace();

            }
        }

        System.out.println("Количество ошибок: " + errorCount);

    }

    @Test
    public void testMartSpecPagesUK() {
        String[] pageUrls = {
                "/uk",
                "/uk/about",
                "/uk/privacy-policy",
                "/uk/mission",
                "/uk/team",
                "/uk/bodymass",
                "/uk/bodyzinc",
                "/uk/bodysize",
                "/uk/electrolyte",
                "/uk/emotion",
                "/uk/waistline",
                "/uk/vitamin"
        };

        String[] expectedTitles = {
                // Landing
                "Фітнес і Здоров'я",
                //About
                "Про нас | Martspec",
                //Privacy
                "Конфіденційність | Martspec",
                //Mission
                "Наша Мета | Martspec",
                //Team
                "Наша Команда | Martspec",
                //Body Mass
                "Вага - найлегший трекер ваги",
                //Body Zinc
                "Цинк - чудовий трекер для вашого годинника",
                //Body Size
                "Фігура - Відстежуйте заміри тіла, щоб досягти своїх цілей у фітнесі та здоров'ї.",
                //Electrolyte
                "Електроліти - відстежуйте здоровий баланс основних мінералів",
                //Emotion
                "Емоція - найшвидший тест особистості",
                //Waistlane
                "Талія - здорове серце, ідеальне тіло",
                //Vitamin
                "Вітамін - відстежуйте все своє харчування"
        };

        String[] expectedDescriptions = {
                // Landing
                "Контролюйте своє здоров'я та настрій за допомогою простих додатків Martspec. Легко відстежуйте свій фізичний і психічний стан, і як покращується ваше самопочуття.",
                //About
                "З 2020 року ми створюємо застосунки, використовуючи передові технології, які дають вам змогу взяти на себе відповідальність за своє здоров’я та самопочуття.",
                //Privacy
                "Захист вашої особистої інформації є нашим пріоритетом. Ця сторінка описує нашу політику та процедури щодо збору, використання та розкриття вашої інформації, коли ви використовуєте будь-який з наших мобільних додатків, відвідуєте наш веб-сайт martspec.com або взаємодієте з нами іншими способами, включаючи продажі, маркетинг або заходи.",
                //Mission
                "Ми робимо так, щоб кожен міг швидко та легко відстежувати своє здоров'я та самопочуття.",
                //Team
                "Люди, які створюють компанію, так само важливі, як і сама компанія. Познайомтеся з нашими талановитими інженерами-програмістами, дизайнерами та копірайтерами, які створюють найкращі оздоровчі додатки.",
                //Body Mass
                "Відстеження ваги підвищує ефективність використання часу та тренувань. Простий у використанні додаток для Apple Watch з повною підтримкою Apple Health.",
                //Body Zinc
                "Цинк підвищує імунну активність, стабілізує рівень цукру в крові та допомагає вашій шкірі, очам і серцю залишатися здоровими.",
                //Body Size
                "З легкістю відстежуйте основні виміри, такі як обсяг бюсту, ширина плечей, обхват талії, стегон та інші, завдяки універсальності вашого Apple Watch, iPhone або iPad.",
                //Electrolyte
                "Електроліти є важливими компонентами для підтримки гомеостазу організму. Легко відстежуйте ці життєво важливі елементи за допомогою нашого зручного додатку для Apple Watch, що має повну інтеграцію з Apple Health для оптимальної підтримки здоров'я.",
                //Emotion
                "Несподівані перепади настрою? Інтенсивні емоційні зміни? З'ясуйте першопричину всього за 1 хвилину.",
                //Waistlane
                "Відстежуйте обхват талії прямо зі свого зап'ястя за допомогою простого у використанні додатку Apple Watch. Відстежуйте свій прогрес та користуйтеся повною підтримкою Apple Health.",
                //Vitamin
                "Легко відстежуйте свої вітаміни, мінерали, пігулки та добавки на Apple Watch, iPhone, iPad або Mac за допомогою нашого зручного додатку. Безкоштовна синхронізація даних з Apple Health."
        };

        int errorCount = 0; // Счетчик ошибок

        for (int i = 0; i < pageUrls.length; i++) {
            String pageUrl = pageUrls[i];
            String expectedTitle = expectedTitles[i];
            String expectedDescription = expectedDescriptions[i];

            Selenide.open(pageUrl);

            try {
                // Проверка заголовка страницы
                assertEquals(expectedTitle, Selenide.title());

                // Проверка тега "description"
                String actualDescription = $(By.cssSelector("meta[name='description']")).getAttribute("content");
                assertTrue(StringUtils.replace(actualDescription, "\u00A0", " ").contains(expectedDescription));

//                // Проверка тега "og:description"
//                String actualOgDescription = $(By.cssSelector("meta[property='og:description']")).getAttribute("content");
//                assertTrue(StringUtils.replace(actualOgDescription, "\u00A0", " ").contains(expectedDescription));
            } catch (AssertionError e) {
                errorCount++;
                System.out.println("Ошибка при проверке страницы: " + pageUrl);
                e.printStackTrace();

            }
        }

        System.out.println("Количество ошибок: " + errorCount);
    }

    @Test
    public void testMartSpecPagesDE() {
        String[] pageUrls = {
                "/de",
                "/de/about",
                "/de/privacy-policy",
                "/de/mission",
                "/de/team",
                "/de/bodymass",
                "/de/bodyzinc",
                "/de/bodysize",
                "/de/electrolyte",
                "/de/emotion",
                "/de/waistline",
                "/de/vitamin"
        };

        String[] expectedTitles = {
                // Landing
                "Gesundheit und Wohlbefinden",
                //About
                "Über uns | Martspec",
                //Privacy
                "Datenschutz | Martspec",
                //Mission
                "Unsere Mission | Martspec",
                //Team
                "Unser Team | Martspec",
                //Body Mass
                "Gewicht - Der leichteste Gewichtsmesser",
                //Body Zinc
                "Zink - fantastischer Tracker für Ihre Armbanduhr",
                //Body Size
                "Körper Form - Verfolgen Sie Ihre Körpermaße",
                //Electrolyte
                "Elektrolyte - Verfolgen Sie ein gesundes Gleichgewicht an wichtigen Mineralien",
                //Emotion
                "Emotion - Der schnellste Persönlichkeitstest",
                //Waistlane
                "Taille - Gesundes Herz, idealer Körper",
                //Vitamin
                "Vitamin - Verfolgen Sie Ihre Ernährung"
        };

        String[] expectedDescriptions = {
                // Landing
                "Kontrollieren Sie Ihre Gesundheit und Ihr Glück mit den wunderbar einfachen Martspec-Apps. Verfolgen Sie Ihr körperliches und geistiges Wohlbefinden mit Leichtigkeit, während sich Ihr Wohlbefinden verbessert.",
                //About
                "Seit 2020 entwickeln wir Apps mit modernster Technologie, die es Ihnen ermöglichen, Ihre persönliche Reise zu Gesundheit und Wohlbefinden selbst in die Hand zu nehmen.",
                //Privacy
                "Der Schutz Ihrer persönlichen Daten ist unsere Priorität. Auf dieser Seite werden unsere Richtlinien und Verfahren für die Erfassung, Verwendung und Weitergabe Ihrer Daten beschrieben, wenn Sie eine unserer mobilen Apps verwenden, unsere Website martspec.com besuchen oder auf andere Weise mit uns in Kontakt treten - einschließlich Vertrieb, Marketing oder Veranstaltungen.",
                //Mission
                "Wir machen es für jeden einfach, seine Gesundheit und sein Wohlbefinden zu verfolgen.",
                //Team
                "Die Menschen hinter dem Unternehmen sind genauso wichtig wie das Unternehmen selbst. Lernen Sie unsere hochtalentierten Software-Ingenieure, Designer und Werbetexter kennen, die die besten Wellness-Anwendungen entwickeln.",
                //Body Mass
                "Die Verfolgung Ihres Gewichts steigert Ihre Effizienz in Bezug auf Ihre Zeit und Ihr Training. Einfach zu bedienende Apple Watch App mit der vollen Unterstützung von Apple Health.",
                //Body Zinc
                "Zink kann die Immunfunktion stärken, den Blutzuckerspiegel stabilisieren und dazu beitragen, dass Ihre Haut, Ihre Augen und Ihr Herz gesund bleiben.",
                //Body Size
                "Überwachen Sie mühelos wichtige Messwerte wie Brustumfang, Schulterbreite, Taillenumfang, Hüfte und mehr mit Ihrer Apple Watch, Ihrem iPhone oder iPad.",
                //Electrolyte
                "Elektrolyte sind entscheidende Komponenten für die Aufrechterhaltung der Homöostase des Körpers. Überwachen Sie diese lebenswichtigen Elemente mühelos mit unserer benutzerfreundlichen Apple Watch App, die für eine optimale Wellness-Unterstützung vollständig in Apple Health integriert ist.",
                //Emotion
                "Unerwartete Stimmungsschwankungen? Intensive emotionale Veränderungen? Finden Sie die Ursache in nur 1 Minute heraus.",
                //Waistlane
                "Mit der benutzerfreundlichen Apple Watch App können Sie Ihren Taillenumfang direkt an Ihrem Handgelenk messen. Überwachen Sie Ihre Fortschritte im Laufe der Zeit und genießen Sie die volle Unterstützung von Apple Health.",
                //Vitamin
                "Mit unserer benutzerfreundlichen App können Sie Ihre Vitamine, Mineralien, Tabletten und Nahrungsergänzungsmittel ganz einfach auf Ihrer Apple Watch, Ihrem iPhone, iPad oder Mac verfolgen. Kostenlose Datensynchronisation mit Apple Health."
        };

        int errorCount = 0; // Счетчик ошибок

        for (int i = 0; i < pageUrls.length; i++) {
            String pageUrl = pageUrls[i];
            String expectedTitle = expectedTitles[i];
            String expectedDescription = expectedDescriptions[i];

            Selenide.open(pageUrl);

            try {
                // Проверка заголовка страницы
                assertEquals(expectedTitle, Selenide.title());

                // Проверка тега "description"
                String actualDescription = $(By.cssSelector("meta[name='description']")).getAttribute("content");
                assertTrue(StringUtils.replace(actualDescription, "\u00A0", " ").contains(expectedDescription));

//                // Проверка тега "og:description"
//                String actualOgDescription = $(By.cssSelector("meta[property='og:description']")).getAttribute("content");
//                assertTrue(StringUtils.replace(actualOgDescription, "\u00A0", " ").contains(expectedDescription));
            } catch (AssertionError e) {
                errorCount++;
                System.out.println("Ошибка при проверке страницы: " + pageUrl);
                e.printStackTrace();

            }
        }

        System.out.println("Количество ошибок: " + errorCount);

    }

    @Test
    public void testMartSpecPagesFR() {
        String[] pageUrls = {
                "/fr",
                "/fr/about",
                "/fr/privacy-policy",
                "/fr/mission",
                "/fr/team",
                "/fr/bodymass",
                "/fr/bodyzinc",
                "/fr/bodysize",
                "/fr/electrolyte",
                "/fr/emotion",
                "/fr/waistline",
                "/fr/vitamin"
        };

        String[] expectedTitles = {
                // Landing
                "Santé et Bien-être",
                //About
                "Découvrez-Nous | Martspec",
                //Privacy
                "Politique de Confidentialité | Martspec",
                //Mission
                "Notre Mission | Martspec",
                //Team
                "Notre Equipe | Martspec",
                //Body Mass
                "Poids - Le traqueur de poids le plus léger",
                //Body Zinc
                "Zinc - Un tracker exceptionnel pour votre montre",
                //Body Size
                "Belle Forme - Corps parfait. Fait par toi!",
                //Electrolyte
                "Electrolyte - Suivi de l'équilibre des minéraux essentiels",
                //Emotion
                "Émotion - Le test de personnalité le plus rapide",
                //Waistlane
                "Taille - Coeur sain, corps idéal",
                //Vitamin
                "Vitamine - Suivez toute votre nutrition"
        };

        String[] expectedDescriptions = {
                // Landing
                "Contrôlez votre santé et votre bonheur grâce aux applications Martspec d'une grande simplicité. Suivez l'évolution de votre bien-être physique et mental au fur et à mesure qu'il s'améliore.",
                //About
                "Depuis 2020, nous créons des applications utilisant une technologie de pointe qui vous permet de prendre en charge votre parcours personnel de santé et de bien-être.",
                //Privacy
                "La protection de vos informations privées est notre priorité. Cette page décrit nos politiques et procédures sur la collecte, l'utilisation et la divulgation de vos informations lorsque vous utilisez l'une de nos applications mobiles, visitez notre site Web à l'adresse martspec.com ou vous engagez avec nous d'autres façons connexes - y compris les ventes, le marketing ou les événements.",
                //Mission
                "Nous permettons à chacun de suivre rapidement et facilement son état de santé et de bien-être.",
                //Team
                "Les personnes à l'origine de l'entreprise sont aussi importantes que l'entreprise elle-même. Rencontrez nos ingénieurs logiciels, concepteurs et rédacteurs hautement talentueux qui créent les meilleures applications de bien-être.",
                //Body Mass
                "Le suivi de votre poids augmente votre efficacité en termes de temps et de séances d'entraînement. L'application Apple Watch est facile à utiliser et bénéficie de la prise en charge complète d'Apple Health.",
                //Body Zinc
                "Le Zinc peut renforcer la fonction immunitaire, stabiliser le taux de sucre dans le sang et aider la peau, les yeux et le cœur à rester en bonne santé.",
                //Body Size
                "Contrôlez sans effort les mesures essentielles telles que le tour de poitrine, la largeur des épaules, le tour de taille, les hanches et bien plus encore grâce à la polyvalence de votre Apple Watch, iPhone ou iPad.",
                //Electrolyte
                "Les électrolytes sont des composants essentiels au maintien de l'homéostasie du corps. Surveillez sans effort ces éléments vitaux grâce à notre application Apple Watch conviviale, qui bénéficie d'une intégration complète avec Apple Health pour un soutien optimal au bien-être.",
                //Emotion
                "Sautes d'humeur inattendues ? Des changements émotionnels intenses ? Déterminez la cause première en seulement 1 minute.",
                //Waistlane
                "Suivez votre tour de taille depuis votre poignet grâce à une application Apple Watch facile à utiliser. Suivez vos progrès au fil du temps et bénéficiez de l'assistance complète d'Apple Health.",
                //Vitamin
                "Suivez facilement vos vitamines, minéraux, pilules et suppléments sur votre Apple Watch, iPhone, iPad ou Mac grâce à notre application conviviale. Synchronisation gratuite des données avec Apple Health."
        };

        int errorCount = 0; // Счетчик ошибок

        for (int i = 0; i < pageUrls.length; i++) {
            String pageUrl = pageUrls[i];
            String expectedTitle = expectedTitles[i];
            String expectedDescription = expectedDescriptions[i];

            Selenide.open(pageUrl);

            try {
                // Проверка заголовка страницы
                assertEquals(expectedTitle, Selenide.title());

                // Проверка тега "description"
                String actualDescription = $(By.cssSelector("meta[name='description']")).getAttribute("content");
                assertTrue(StringUtils.replace(actualDescription, "\u00A0", " ").contains(expectedDescription));

//                // Проверка тега "og:description"
//                String actualOgDescription = $(By.cssSelector("meta[property='og:description']")).getAttribute("content");
//                assertTrue(StringUtils.replace(actualOgDescription, "\u00A0", " ").contains(expectedDescription));
            } catch (AssertionError e) {
                errorCount++;
                System.out.println("Ошибка при проверке страницы: " + pageUrl);
                e.printStackTrace();

            }
        }

        System.out.println("Количество ошибок: " + errorCount);

    }

}
