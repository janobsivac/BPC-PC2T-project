# Knihovní Systém

Tento projekt představuje jednoduchý systém pro správu knihovny, který umožňuje uživatelům přidávat, aktualizovat, mazat a vyhledávat knihy v knihovně. Podporuje dvě typy knih: romány a učebnice.

## Funkce

- **Přidání knihy:** Umožňuje uživatelům přidat novou knihu do systému.
- **Aktualizace knihy:** Uživatelé mohou aktualizovat informace o existujících knihách.
- **Mazání knihy:** Knihy mohou být odstraněny z knihovního systému.
- **Vyhledávání knihy:** Uživatelé mohou vyhledávat knihy podle názvu, autora nebo žánru.
- **Zobrazení všech knih:** Zobrazí seznam všech knih v knihovně.
- **Ukládání a načítání knih:** Informace o knihách mohou být uloženy do souboru a načteny zpět.

## Technologie

- **Java**: Hlavní programovací jazyk.
- **SQLite**: Databázový systém použitý pro ukládání informací o knihách.
- **Maven**: Nástroj pro správu projektu a automatizaci sestavení.

## Instalace

Před spuštěním tohoto projektu je potřeba mít nainstalované následující závislosti:

1. Java Development Kit (JDK) - Doporučujeme verzi 11 nebo novější.
2. Maven - Pro správu závislostí a sestavení projektu.
3. SQLite JDBC Driver - Pro komunikaci s databází SQLite.

## Spuštění aplikace

Pro spuštění aplikace postupujte takto:

1. Stáhněte zdrojový kód projektu.
2. Otevřete terminál nebo příkazovou řádku ve složce projektu.
3. Spusťte příkaz: `mvn clean install` pro sestavení projektu.
4. Spusťte aplikaci pomocí `java -jar target/knihovni-system.jar`.

## Příklad použití

Zde je několik příkladů příkazů, které můžete v aplikaci použít:

- Přidání knihy: Zvolte možnost 1 a postupujte podle instrukcí.
- Aktualizace knihy: Zvolte možnost 2 a zadajte název knihy, kterou chcete aktualizovat.
- Mazání knihy: Zvolte možnost 3 a zadajte název knihy k odstranění.
