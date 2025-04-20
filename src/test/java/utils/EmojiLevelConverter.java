package utils;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.core.pattern.PatternConverter;

@Plugin(name = "EmojiLevelConverter", category = PatternConverter.CATEGORY)
@ConverterKeys({"emojiLevel"})
public class EmojiLevelConverter extends LogEventPatternConverter {

  protected EmojiLevelConverter(String name, String style) {
    super(name, style);
  }

  public static EmojiLevelConverter newInstance(String[] options) {
    return new EmojiLevelConverter("emojiLevel", "level");
  }

  @Override
  public void format(LogEvent event, StringBuilder toAppendTo) {
    String emoji;
    switch (event.getLevel().name()) {
      case "INFO":
        emoji = "✅ ";
        break;
      case "DEBUG":
        emoji = "🔍 ";
        break;
      case "ERROR":
        emoji = "❌ ";
        break;
      case "WARN":
        emoji = "⚠️  ";
        break;
      case "TRACE":
        emoji = "🧵 ";
        break;
      case "FATAL":
        emoji = "🔥 ";
        break;
      default:
        emoji = "";
    }
    toAppendTo.append(emoji);
  }
}
