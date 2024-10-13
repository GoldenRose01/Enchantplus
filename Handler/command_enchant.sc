# Handler for /enchant command
command_enchant_handler(player, args) -> (
    enchantment = args[0];
    level = args[1];
    
    # Verifica se l'incantesimo è vanilla o custom
    (vanilla_enchants, custom_enchants) = run('__config');
    
    if(vanilla_enchants~has(enchantment),
        # Applica l'incantesimo vanilla
        player~'enchant'(enchantment, level);
    );
    
    if(custom_enchants~has(enchantment),
        # Applica l'incantesimo custom
        run('apply_custom_enchantment', player, enchantment, level);
    );
);

# Funzione placeholder per applicare incantesimi custom
apply_custom_enchantment(player, enchantment, level) -> (
    # Logica per applicare gli incantesimi custom sarà implementata in futuro
    print('Applying custom enchantment: ', enchantment, ' with level ', level);
);
