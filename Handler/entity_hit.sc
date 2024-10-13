# Handler for when an entity is hit by a player
__on_player_hit_entity(player, entity) -> (
    # Check if it's a critical hit
    if(entity~'is_critical_hit',
        run('__on_critical_hit', player, entity);
    );
);

# Helper function to get the level of the Experienced enchantment
get_enchantment_level(player, enchantment) -> (
    held_item = player~'main_hand';
    enchantment_level = 0;
    
    if(held_item~'has_enchantments',
        enchantments = held_item~'get_enchantments';
        if(enchantments~has(enchantment),
            enchantment_level = enchantments[enchantment];
        );
    );
    
    return enchantment_level;
);
