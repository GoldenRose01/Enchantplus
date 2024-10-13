# Handler for adding enchantments to the creative inventory
creative_inventory_handler(item, category) -> (
    if(category == 'tools',
        run('creative_add_item', 'enchanted_book', '{"StoredEnchantments":[{"id":"Experienced","lvl":1}]}');
        run('creative_add_item', 'enchanted_book', '{"StoredEnchantments":[{"id":"Triumph","lvl":3}]}');
        run('creative_add_item', 'enchanted_book', '{"StoredEnchantments":[{"id":"Leeching Aspect","lvl":2}]}');
        # Aggiungi altri incantesimi qui
    );
);
