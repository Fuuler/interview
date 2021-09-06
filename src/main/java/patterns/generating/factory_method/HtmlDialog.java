package patterns.generating.FactoryMethod;

/**
 * HTML - диалог.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
