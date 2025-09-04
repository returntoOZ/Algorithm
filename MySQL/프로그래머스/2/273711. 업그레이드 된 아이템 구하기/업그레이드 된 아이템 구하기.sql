select c.item_id, c.item_name, c.rarity
from item_info c
    join item_tree t on c.item_id = t.item_id
    join item_info p on t.parent_item_id = p.item_id
where p.rarity = 'RARE'
order by c.item_id desc