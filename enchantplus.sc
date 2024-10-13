# Main runner for enchantment management from config.json

__config() -> (
    # Load the config file
    config = load_json('config.json');
    
    # Load vanilla enchantments
    vanilla_enchants = config~'vanilla_enchants';
    
    # Load custom enchantments
    custom_enchants = config~'custom_enchants';
    
    return (vanilla_enchants, custom_enchants);
);

# Add enchantments to the creative inventory
__on_creative_inventory((item, category) -> (
    # Call the handler for managing creative inventory enchantments
    run('creative_inventory_handler', item, category);
));

# Add enchantments to the /enchant command
__on_command("enchant", (player, args) -> (
    # Call the handler for managing the /enchant command
    run('command_enchant_handler', player, args);
));

# Check and handle advanced enchanting table setup
__on_command("advanced_enchant", (player, args) -> (
    run('Table/check_advanced_enchanting_table', player);
));
