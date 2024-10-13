# Enchantment specific script for Experienced
experienced_apply_effect(player) -> (
    # Verifica se l'incantesimo Experienced è presente sull'arma
    level = run('get_enchantment_level', player, 'Experienced');
    
    # Se l'incantesimo è attivo, calcola il moltiplicatore basato sull'esperienza
    if(level > 0,
        xp_level = player~'xp_level';
        crit_multiplier = 1 + (xp_level * 0.01);  # Ogni livello di esperienza aumenta il danno critico dell'1%
        return crit_multiplier;
    );
    
    return 1;  # Se non c'è l'incantesimo, il moltiplicatore è 1 (nessun bonus)
);

# Regola per colpi critici
__on_critical_hit(player, target) -> (
    crit_multiplier = run('experienced_apply_effect', player);
    damage = target~'get_damage';
    new_damage = damage * crit_multiplier;
    target~'set_damage'(new_damage);
);
