## About
SeedProtect is a simple and lightweight plugin that adds an extra layer of protection to your server. It is the perfect plugin for those who wish to keep their server seed private. If a player enters the server seed in chat, the message will be automatically deleted, and the player will either be banned or muted. Everything is configurable in the configuration file.

## Setup
The plugin does not require any initial setup, simply drag and drop the plugin into the plugins folder, restart your server and you're ready to go. Commands executed when a player enters the server seed in chat can be configured in the [configuration file](https://github.com/dev-stan/SeedProtect/blob/master/src/main/resources/config.yml)

```YAML
# What should the plugin do when a player enters the seed in chat?
ban-player: true
banip-player: true
mute-player: true

# For how long should the player be banned / muted if one of the options above is set to true
# Set to "null" if you want the ban / mute time to be infinite
ban-time: "null" # For example 1d
mute-time: "null" # For example 1h
```

