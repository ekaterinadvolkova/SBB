{
    document.querySelectorAll('[data-mask]').forEach(item => {
        const mask = new Inputmask(item.dataset.mask);
        if (mask) {
            mask.mask(item);
        }
    });
}

{
    const addStation = document.querySelector('#add-station');
    if(addStation){
        const container = document.querySelector('#stations-container');
        const template = document.querySelector('#station-item');

        addStation.addEventListener('click',()=>{
            const clone = template.content.cloneNode(true);
            container.append(clone);
        });
    }
}
